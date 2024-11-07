## Task: Sci-fi Spaceship Repair Game 🚀

Welcome to your programming challenge! In this task, you'll design and develop a Sci-fi themed text-based game set within the confines of a spaceship. Your mission is to create a game where the player must navigate through various rooms on a spaceship to repair it before time runs out. This task will help you understand the concepts of using data from files to instantiate objects, designing classes, and programming creatively.

### Objective

- **Theme**: Create a Sci-fi game where players move through rooms in a spaceship. The player's goal is to repair the ship by visiting specific rooms and taking corrective actions.

### Learning Goals

1. **Using Data from Files to Instantiate Objects**
   - Understanding file formats and parsing techniques for data extraction.
   - Using file I/O classes to read data and convert it into object attributes.
   - Handling exceptions and ensuring data integrity during object instantiation.

2. **Designing Classes**
   - Identifying class responsibilities and defining clear interfaces.
   - Implementing cohesive class structures with appropriate fields and methods.
   - Leveraging design patterns to enhance class design.

3. **Programming Creatively**
   - Exploring different approaches to problem-solving.
   - Encouraging experimentation and iteration to refine solutions.
   - Integrating user feedback and testing to improve program effectiveness.

### Exercises

#### Exercise 1: Theoretical Foundation of File I/O 📂
- **Objective**: Understand the basics of file I/O operations in Java, essential for setting up dynamic data handling.
- **Task**: 
  - **Q1**: Explain the importance of file I/O in Java and list the common classes used for reading and writing files.
  - **Q2**: Describe two scenarios in a spaceship-themed game where using file input/output could enhance gameplay.

#### Exercise 2: Principles of Class Design 📐
- **Objective**: Study the principles that underlie effective class design in Java.
- **Task**: 
  - **Q1**: What are class responsibilities, and why are they important in object-oriented programming?
  - **Q2**: Discuss common design patterns that can be beneficial in the architecture of a spaceship game.

#### Exercise 3: Implementing File-Based Room Initialization 🗂️
- **Objective**: Use file data to dynamically create room objects within your game's spaceship environment.
- **Task**:
  - **Description**: Create a method `generateSpaceshipLayout` that reads a text file to set up the spaceship's rooms.
    - File Format: One line per room specifying `'Room;RoomName;Description'`.
    - Another with `'Exit;FromRoom;Direction;ToRoom'`.
  - **Code Snippet**:

    ```java
    private void generateSpaceshipLayout(String filename) {
        // Implement the method to read room and exit configuration from a file
    }
    ```

#### Exercise 4: Designing Game-Specific Classes 🛠️
- **Objective**: Create custom classes that represent game-specific entities within the spaceship.
- **Task**:
  - **Code Snippet**: Define a class `RepairTool` representing tools needed to fix the spaceship.

    ```java
    public class RepairTool {
        private String name;
        private String functionality;

        public RepairTool(String name, String functionality) {
            this.name = name;
            this.functionality = functionality;
        }
        
        // Getter and Setter methods
    }
    ```

#### Exercise 5: Integrating Tools and Gameplay Mechanics ⚙️
- **Objective**: Integrate your custom tools into the game mechanics, allowing interaction.
- **Task**:
  - Develop a gameplay feature where certain rooms contain repair tools necessary for fixing the spaceship.
  - Ensure the player must pick up and use these tools within rooms.

#### Exercise 6: Complete Game Creation and Testing 🧩
- **Objective**: Combine all elements to create a fully functional game with a win/lose condition.
- **Steps**:
  - Implement the logic for 'repairing' the spaceship.
  - Add a win condition when repairs are completed within specific rounds.
  - Create a README with a game map and a description of how to play.

### Submission

- Submit a ZIP file containing your code, a room data file, and the README with game documentation and map.
- Ensure the code is well-documented using Javadoc conventions.

### Tips for Success

- Start by understanding the file I/O operations deeply.
- Design your classes with clear responsibilities.
- Continuously test each component as you integrate them.

Embark on your cosmic journey and bring the spaceship back to life! 🌌