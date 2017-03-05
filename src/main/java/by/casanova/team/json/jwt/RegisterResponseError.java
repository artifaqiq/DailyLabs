package by.casanova.team.json.jwt;

import com.google.gson.annotations.Expose;
import org.springframework.http.HttpStatus;

/**
 * Created by artifaqiq on 3/5/17.
 */
public class RegisterResponseError {

    @Expose
    private HttpStatus status;

    @Expose
    private String description;

    public RegisterResponseError() { }

    public RegisterResponseError(HttpStatus status, String description) {
        this.status = status;
        this.description = description;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RegisterResponseError{" +
                "status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
