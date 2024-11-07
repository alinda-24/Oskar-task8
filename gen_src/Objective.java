public class Objective {
    private String name;
    private String description;


    private boolean completed;


    public Objective(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

}
