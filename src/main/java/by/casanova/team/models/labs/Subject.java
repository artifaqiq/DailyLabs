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
@Table(name = "SUBJECTS")
public class Subject implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Expose
    @Column
    private String name;

    @Expose
    @Column
    private String description;

    @Expose
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "subject")
    private List<Lab> labs;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DIARY_ID", nullable = false)
    private Diary diary;

    public Subject(String name, String description, List<Lab> labs, Diary diary) {
        this.name = name;
        this.description = description;
        this.labs = labs;
        this.diary = diary;
    }

    public Subject() { }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public void setLabs(List<Lab> labs) {
        this.labs = labs;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", labs=" + labs +
                '}';
    }

    @Override
    public Subject clone() {
        return new Subject(name, description, new ArrayList<>(labs), diary);
    }

}
