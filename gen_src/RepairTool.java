// File: RepairTool.java
public class RepairTool {
    private String name;
    private String functionality;
    

    // Constructor
    public RepairTool(String name, String functionality) {
        this.name = name;
        this.functionality = functionality;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for functionality
    public String getFunctionality() {
        return functionality;
    }   

    // Setter for functionality
    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }
}