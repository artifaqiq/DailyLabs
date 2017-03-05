package by.casanova.team.json.user;

import com.google.gson.annotations.Expose;

/**
 * Created by artifaqiq on 3/5/17.
 */
public class RegisteringUserModel {

    @Expose
    private String username;

    @Expose
    private String password;

    @Expose
    private String password_confirm;

    public RegisteringUserModel() {}

    public RegisteringUserModel(String username, String password, String password_confirm) {
        this.username = username;
        this.password = password;
        this.password_confirm = password_confirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    @Override
    public String toString() {
        return "RegisteringUserModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", password_confirm='" + password_confirm + '\'' +
                '}';
    }
}
