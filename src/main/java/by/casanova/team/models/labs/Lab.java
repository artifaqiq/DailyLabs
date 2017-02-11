package by.casanova.team.models.labs;

import javax.persistence.*;

/**
 * Created by artifaqiq on 2/8/17.
 */
@Entity
@Table(name = "LABS")
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private boolean passed;

    @Column
    private String description;

    public Lab() { }

    public Lab(String name, boolean passed, String description, long id) {
        this.name = name;
        this.passed = passed;
        this.description = description;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return new Lab(name, passed, description, id);
    }
}
