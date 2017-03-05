package by.casanova.team.controllers.api;

import by.casanova.team.json.jwt.RegisterResponseError;
import by.casanova.team.json.jwt.RegisterResponseOk;
import by.casanova.team.json.user.LoginUserModel;
import by.casanova.team.json.user.RegisteringUserModel;
import by.casanova.team.models.user.User;
import by.casanova.team.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        RegisteringUserModel registeringUser;
        String token;
        try {
            registeringUser =
                    (RegisteringUserModel) gson.fromJson(body, RegisteringUserModel.class);
        } catch (JsonSyntaxException exception) {

            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            RegisterResponseError response = new RegisterResponseError(status,
                    ErrorsMessagesConstants.INVALID_JSON);
            return new ResponseEntity<Object>(gson.toJson(response), status);
        }

        //TODO validation
        if (registeringUser.getUsername() == null || registeringUser.getPassword() == null ||
                registeringUser.getPassword_confirm() == null ||
                !registeringUser.getPassword().equals(registeringUser.getPassword_confirm())) {

            HttpStatus status = HttpStatus.FORBIDDEN;
            RegisterResponseError response = new RegisterResponseError(status,
                    ErrorsMessagesConstants.PASSWORDS_DOESNT_EQUAL);

            return new ResponseEntity<Object>(gson.toJson(response), status);
        } else if (userService.exists(registeringUser.getUsername())) {
            HttpStatus status = HttpStatus.CONFLICT;

            RegisterResponseError response = new RegisterResponseError(status,
                    ErrorsMessagesConstants.REPEATED_USERNAME);
            return new ResponseEntity<Object>(gson.toJson(response), status);
        } else {

            User newUser = new User();
            newUser.setUsername(registeringUser.getUsername());
            newUser.setPassword(registeringUser.getPassword());
            newUser.setEnabled(true);
            newUser = userService.save(newUser);

            HttpStatus status = HttpStatus.OK;
            RegisterResponseOk response = new RegisterResponseOk(newUser.getJwtToken(), status);

            return new ResponseEntity<>(gson.toJson(response), HttpStatus.OK);
        }

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

interface ErrorsMessagesConstants {
    public static final String PASSWORDS_DOESNT_EQUAL = "Fields must not be empty and 'password' must be equal 'password_confirm'";
    public static final String INVALID_JSON = "Json syntax error";
    public static final String REPEATED_USERNAME = "User with some username already exists";
}
