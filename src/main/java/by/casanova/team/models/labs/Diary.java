package by.casanova.team.models.labs;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
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

    @Expose
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "diary")
    private List<Subject> subjects;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Diary{ id=" + id +
                " ,subjects=" + subjects +
                '}';
    }

    @Override
    public Diary clone() {
        return new Diary(new ArrayList<>(subjects));
    }
}
