package by.casanova.team.json.user;

/**
 * Created by artifaqiq on 3/5/17.
 */
public class LoginUserModel {
    private String username;

    private String password;

    public LoginUserModel() {}

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

    public LoginUserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUserModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
