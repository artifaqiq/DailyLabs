package by.casanova.team.controllers.api;

import by.casanova.team.json.jwt.AuthResponseError;
import by.casanova.team.json.jwt.AuthResponseOk;
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
        try {
            registeringUser = gson.fromJson(body, RegisteringUserModel.class);
        } catch (JsonSyntaxException exception) {

            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.INVALID_JSON);
            return new ResponseEntity<Object>(gson.toJson(response), status);
        }

        //TODO validation
        if (registeringUser.getUsername() == null || registeringUser.getPassword() == null ||
                registeringUser.getPassword_confirm() == null ||
                !registeringUser.getPassword().equals(registeringUser.getPassword_confirm())) {

            HttpStatus status = HttpStatus.FORBIDDEN;
            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.PASSWORDS_DOESNT_EQUAL);

            return new ResponseEntity<Object>(gson.toJson(response), status);
        } else if (userService.exists(registeringUser.getUsername())) {
            HttpStatus status = HttpStatus.CONFLICT;

            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.REPEATED_USERNAME);
            return new ResponseEntity<Object>(gson.toJson(response), status);
        } else {

            User newUser = new User();
            newUser.setUsername(registeringUser.getUsername());
            newUser.setPassword(registeringUser.getPassword());
            newUser.setEnabled(true);
            newUser = userService.save(newUser);

            HttpStatus status = HttpStatus.OK;
            AuthResponseOk response = new AuthResponseOk(newUser.getJwtToken(), status);

            return new ResponseEntity<>(gson.toJson(response), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody String body) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        LoginUserModel loginUser;

        try {
            loginUser = gson.fromJson(body, LoginUserModel.class);
        } catch (JsonSyntaxException exception) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.INVALID_JSON);

            return new ResponseEntity<Object>(gson.toJson(response), status);
        }

        if(loginUser.getPassword() == null || loginUser.getUsername() == null) {
            HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.INVALID_JSON);

            return new ResponseEntity<Object>(gson.toJson(response), status);
        }

        User user = userService.verifyUser(loginUser.getUsername(), loginUser.getPassword());

        if(user == null) {
            HttpStatus status = HttpStatus.UNAUTHORIZED;
            AuthResponseError response = new AuthResponseError(status,
                    ErrorsMessagesConstants.WRONG_PASSWORD_OR_USERNAME);

            return new ResponseEntity<Object>(gson.toJson(response), HttpStatus.UNAUTHORIZED);
        }

        AuthResponseOk response = new AuthResponseOk(user.getJwtToken(), HttpStatus.OK);
        return new ResponseEntity<Object>(gson.toJson(response), HttpStatus.OK);
    }
}

interface ErrorsMessagesConstants {
    public static final String PASSWORDS_DOESNT_EQUAL = "Fields must not be empty and 'password' must be equal 'password_confirm'";
    public static final String INVALID_JSON = "Json syntax error";
    public static final String REPEATED_USERNAME = "User with some username already exists";
    public static final String WRONG_PASSWORD_OR_USERNAME = "Wrong username or password";

}

