package by.casanova.team.models.labs;

import by.casanova.team.models.user.User;
import com.google.gson.annotations.Expose;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artifaqiq on 2/8/17.
 */

@Entity
@Table(name = "DIARIES")
public class Diary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @Expose
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "diary")
    private List<Subject> subjects;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now(ZoneOffset.UTC);

    @Expose
    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now(ZoneOffset.UTC);


    public Diary() { }

    public Diary(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", user=" + user +
                ", subjects=" + subjects +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public Diary clone() {
        return new Diary(new ArrayList<>(subjects));
    }
}
