package by.casanova.team.models.labs;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by artifaqiq on 2/8/17.
 */
@Entity
@Table(name = "LABS")
public class Lab implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Expose
    @Column
    private String name;

    @Expose
    @Column
    private boolean passed;

    @Expose
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    public Lab(String name, boolean passed, String description, Subject subject) {
        this.name = name;
        this.passed = passed;
        this.description = description;
        this.subject = subject;
    }

    public Lab() { }


    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passed=" + passed +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public Lab clone() {
        return new Lab(name, passed, description, subject);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab lab = (Lab) o;

        if (id != lab.id) return false;
        if (passed != lab.passed) return false;
        if (name != null ? !name.equals(lab.name) : lab.name != null) return false;
        if (description != null ? !description.equals(lab.description) : lab.description != null) return false;
        return subject != null ? subject.equals(lab.subject) : lab.subject == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passed ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
}
