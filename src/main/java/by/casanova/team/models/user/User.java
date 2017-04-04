package by.casanova.team.models.user;

import by.casanova.team.models.labs.Diary;
import com.google.gson.annotations.Expose;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by artifaqiq on 3/4/17.
 */

@Entity
@Table(name = "USERS")
public class User implements Serializable {

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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "diary_id")
    private Diary diary;

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

    public User() {
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

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
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
                ", diary=" + diary +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        if (diary != null ? !diary.equals(user.diary) : user.diary != null) return false;
        if (createdDate != null ? !createdDate.equals(user.createdDate) : user.createdDate != null) return false;
        if (lastModifiedDate != null ? !lastModifiedDate.equals(user.lastModifiedDate) : user.lastModifiedDate != null)
            return false;
        return jwtToken != null ? jwtToken.equals(user.jwtToken) : user.jwtToken == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (diary != null ? diary.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (lastModifiedDate != null ? lastModifiedDate.hashCode() : 0);
        result = 31 * result + (jwtToken != null ? jwtToken.hashCode() : 0);
        return result;
    }
}
