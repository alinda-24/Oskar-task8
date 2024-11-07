public class Objective {
    private String name;
    private boolean completed;

    public Objective (String name) {
        this.name = name;
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


}
