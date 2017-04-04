package by.casanova.team.json.jwt;

import com.google.gson.annotations.Expose;
import org.springframework.http.HttpStatus;

/**
 * Created by artifaqiq on 3/5/17.
 */
public class AuthResponseOk {
    @Expose
    private String token;

    @Expose
    private HttpStatus status;

    public AuthResponseOk() { }

    public AuthResponseOk(String token, HttpStatus status) {
        this.token = token;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AuthResponseOk{" +
                "token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
