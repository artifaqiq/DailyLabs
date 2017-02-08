package by.casanova.team.models.labs;

/**
 * Created by artifaqiq on 2/8/17.
 */
public class Lab {
    public Lab() { }

    private String name;

    private boolean passed;

    private String description;

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
}
