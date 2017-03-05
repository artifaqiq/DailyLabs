package by.casanova.team.controllers.api;

import by.casanova.team.json.user.LoginUserModel;
import by.casanova.team.json.user.RegisteringUserModel;
import by.casanova.team.models.user.User;
import by.casanova.team.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Gson gson = new Gson();
        String token;
        try {
            RegisteringUserModel registeringUser =
                    (RegisteringUserModel) gson.fromJson(body, RegisteringUserModel.class);


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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody String body) {
        Gson gson = new Gson();
        LoginUserModel loginUser;
        String token = null;

        try {
            loginUser = (LoginUserModel)gson.fromJson(body, LoginUserModel.class);

            if(loginUser.getPassword() == null || loginUser.getUsername() == null) {
                return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
            }

            User user = userService.verifyUser(loginUser.getUsername(), loginUser.getPassword());

            if(user == null) {
                return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
            }

            token = user.getJwtToken();

        } catch (JsonSyntaxException exception) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Object>(token, HttpStatus.OK);
    }
}
