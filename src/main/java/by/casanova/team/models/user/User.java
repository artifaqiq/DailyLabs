package by.casanova.team.models.user;

import com.google.gson.annotations.Expose;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by artifaqiq on 3/4/17.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Expose
    @Column(unique = true, nullable = false, length = 45)
    private String username;

    @Expose
    @Column(nullable = false, length = 60)
    private String password;

    @Expose
    @Column(nullable = false)
    private boolean enabled;

    @Expose
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRole> roles = new HashSet<UserRole>(0);

    @Expose
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC);

    @Expose
    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now(ZoneOffset.UTC);

    @Column(nullable = false, unique = true)
    private String jwtToken;

    public User() {}

    public User(String username, String password, boolean enabled, Set<UserRole> roles, String jwtToken) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.jwtToken = jwtToken;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getJwtToken() {
        return jwtToken;
    }


    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
