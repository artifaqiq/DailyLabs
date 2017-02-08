package by.casanova.team.models.labs;

import java.util.List;

/**
 * Created by artifaqiq on 2/8/17.
 */
public class Subject {
    private String name;

    private String description;

    private List<Lab> labs;

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
}
