![Task Image](https://oaidalleapiprodscus.blob.core.windows.net/private/org-asPC5Skb6EoE1i324HhdGnV1/user-4VyHdJuNDsg3rdcmO7ghXoi2/img-ZPvTxKBEKRClyCSV7OLd9D2A.png?st=2024-11-07T16%3A31%3A56Z&se=2024-11-07T18%3A31%3A56Z&sp=r&sv=2024-08-04&sr=b&rscd=inline&rsct=image/png&skoid=d505667d-d6c1-4a0a-bac7-5c84a87759f8&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2024-11-07T04%3A23%3A33Z&ske=2024-11-08T04%3A23%3A33Z&sks=b&skv=2024-08-04&sig=RjJjYd53QNG5vUprzRzSxRp91nRwEjKy2N2yzDL8mHQ%3D)

### 🎓 Programming Task: Dynamic Story Generation

#### **Theme:** Dynamic Adventure Tale

Welcome to the "Dynamic Adventure Tale" task, where you'll be crafting your own storytelling game using file data to shape the narrative dynamically. This task emphasizes creative programming, effective class design, and handling dynamic data through file input to generate a unique adventure experience.

---

### **Learning Goals**

1. **Using Data from Files to Instantiate Objects**
   - Learn to read and parse data files to create instances of your adventure's world.
  
2. **Designing Classes**
   - Practice designing robust class structures for scalability and maintainability.

3. **Programming Creatively**
   - Use your programming skills to creatively build an engaging and interactive story environment.

---

### **Task Overview**

This task consists of six exercises that gradually increase in complexity, allowing students to explore key programming concepts deeply while creating a fun and interactive application.

---

### **Exercise 1: Understanding File Formats and Parsing Techniques**

🔍 **Objective:**

To grasp the theoretical understanding of file formats and how to parse data effectively for instantiation of objects.

🔸 **Tasks:**

1. Research and describe two common file formats used for storing structured data (e.g., CSV, JSON).
2. Explain how you might extract specific data from these formats for object instantiation.

🔗 **Deliverable:** A short report (1-2 pages) summarizing your findings.

---

### **Exercise 2: Principles of Class Design**

🧩 **Objective:**

Enhance your theoretical understanding of what constitutes good class design in Java.

🔸 **Tasks:**

1. Define class responsibilities and interface principles.
2. Explore a particular design pattern (e.g., Factory, Singleton) and explain how it enhances software design.

🔗 **Deliverable:** A presentation or document addressing these tasks with examples.

---

### **Exercise 3: File I/O and Object Creation**

💻 **Objective:**

Implement basic file reading to instantiate objects.

🔸 **Tasks:**

1. Write a Java program to read a file containing structured data about game locations.
2. Parse the file to create and initialize objects representing each location.

```java
// Example of reading a file in Java
BufferedReader reader = new BufferedReader(new FileReader("locations.txt"));
String line;
while ((line = reader.readLine()) != null) {
    // Process each line and instantiate objects
}
reader.close();
```

🔗 **Deliverable:** A Java program that reads from a file and outputs object data.

---

### **Exercise 4: Implementing Class Designs**

🔨 **Objective:**

Design and implement classes for your adventure game, applying the principles learned.

🔸 **Tasks:**

1. Design a class structure for your game's elements (e.g., Room, Item, Character).
2. Implement these classes in Java, ensuring they follow solid class design principles.

🔗 **Deliverable:** Java classes implementing the designed structures with a main method to demonstrate their use.

---

### **Exercise 5: Dynamic Story Engine Development**

🎮 **Objective:**

Create a dynamic engine for your adventure game using file data to drive the story.

🔸 **Tasks:**

1. Formulate a story flow using files that contain chapters or scenes.
2. Extend your program to read these files and generate a story dynamically.

```java
// Example of extending file reading to drive story events
while ((line = storyReader.readLine()) != null) {
    // Initiate story events based on the current scene
}
```

🔗 **Deliverable:** A functional application that reads story data and interacts dynamically with the user.

---

### **Exercise 6: Advanced Features and Creative Expansion**

🌟 **Objective:**

Add complexity and creativity to your adventure game. Challenge yourself!

🔸 **Tasks:**

1. Integrate user choices affecting the story's outcome.
2. Implement at least one advanced feature (e.g., inventory systems, branching narratives).

🔗 **Deliverable:** A polished, interactive adventure game with documentation and user guides.

---

**🚀 Extra Challenge:**

Document your development process. Share insights into your design decisions and creative process, including setbacks and how you overcame them.

---

### **Submission**

Ensure all Java files, documentation, and auxiliary files (like your map and README) are organized neatly. Submit your work through the university's submission portal.

---

### **Tips for Success**

- Think creatively! This is your opportunity to tell a unique story.
- Pay attention to error handling, especially when reading files.
- Engage with classmates and instructors if you hit a roadblock.
- Have fun with it—creativity is as valuable as technical skill in this task.

Good luck on your journey to create a dynamic, compelling adventure game! 🎉