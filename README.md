# Student Information System

A console-based Student Information System developed in Java as a university team project. The application demonstrates object-oriented programming concepts and manages sample student, teacher, course, grade, and attendance information.

## Features

- Search for a registered student by name.
- Display student details, including ID, department, academic level, and courses.
- View attendance by weekday and calculate the absence percentage.
- Show an attendance notice or warning when absence thresholds are reached.
- Add and remove courses.
- Display teacher information and search for a teacher by name.
- Display course grades, calculate total marks, assign letter grades, and calculate GPA.
- Generate and read attendance data using a local text file.

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- File handling (`BufferedReader`, `PrintWriter`)
- Eclipse project structure

## Project Structure

```text
student-information-system/
├── src/
│   ├── module-info.java
│   └── project/
│       ├── Attendance.java
│       ├── Course.java
│       ├── DeletioonAndAddition.java
│       ├── Grade.java
│       ├── Material.java
│       ├── Person.java
│       ├── Student.java
│       ├── Teacher.java
│       └── Test.java
├── docs/
│   └── UML.pdf
└── README.md
```

## How to Run

1. Open the project in an IDE such as Eclipse.
2. Make sure a Java JDK is configured.
3. Run `project.Test` (the application entry point).
4. Enter one of the sample student names when prompted: `Manar`, `Layan`, or `Jana`.
5. Use the menu to view attendance, manage courses, view teacher information, or display grades.

The application creates `attendance.txt` in its working directory when attendance is initialized.

## Notes

- This is an academic demonstration project that uses predefined sample records.
- Student, teacher, and grade data are held in memory; this project does not use a database.
- Attendance data is generated in a local text file.
- The project was developed collaboratively. Individual contributions should be described separately from the team's overall features.

## My Contribution

Contributed to the attendance functionality, the `Test` class used to run and test the application, and the UML documentation.

---

*University course project — Java / Object-Oriented Programming.*
