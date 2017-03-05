package by.casanova.team.controllers.api.auth;

import by.casanova.team.json.user.RegisteringUserModel;
import by.casanova.team.models.user.User;
import by.casanova.team.service.UserService;
import by.casanova.team.utils.auth.JwtUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


/**
 * Created by artifaqiq on 3/4/17.
 */

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class JwtController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody String body) {

        Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String token = null;
        try {
            RegisteringUserModel registeringUser =
                    (RegisteringUserModel) gson.fromJson(body, RegisteringUserModel.class);


            System.out.println(registeringUser);

            //TODO validation
            if (registeringUser.getUsername() == null || registeringUser.getPassword() == null ||
                    registeringUser.getPassword_confirm() == null ||
                    !registeringUser.getPassword().equals(registeringUser.getPassword_confirm())) {
                return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
            }

            if(userService.exists(registeringUser.getUsername())) {
                return new ResponseEntity<Object>(HttpStatus.CHECKPOINT); //шляпа
            }

            User newUser = new User();
            newUser.setUsername(registeringUser.getUsername());
            newUser.setPassword(registeringUser.getPassword());
            newUser.setEnabled(true);

            newUser = userService.save(newUser);

            token = newUser.getJwtToken();


        } catch (JsonSyntaxException exception) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
