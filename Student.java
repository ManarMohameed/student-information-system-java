package project;

import java.util.ArrayList;

public class Student extends Person {

    private String department;
    private int level;
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private Teacher teacher;

    // Students list for search
    private static ArrayList<Student> studentsList = new ArrayList<>();

    // Default constructor
    public Student() {
        this.department = null;
        this.level = 0;
    }

    // Constructor with teacher
    public Student(Teacher teacher) {
        this.teacher = teacher;
    }

    // Add student to the list
    public static void addStudent(Student s) {
        studentsList.add(s);
    }

    // Search for the student name in the list
    public int searchStudent(String name) {
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Get student by index
    public static Student getStudent(int index) {
        return studentsList.get(index);
    }

    // Student info setup
    public void StudentInfo(int index) {
        Student s = studentsList.get(index);

        setName(s.getName());
        setId(s.getId());

        this.department = "Computer Science";
        this.level = 3;

        grades.clear();
        courses.clear();

        addCourse(new Course("OOP"));
        addCourse(new Course("Logic Design"));
        addCourse(new Course("Cybersecurity"));


        if (index == 0) { // Manar
            addGrade(new Grade("OOP", 9, 20, 5, 40, 20));
            addGrade(new Grade("Logic Design", 4, 5, 19, 50, 8));
            addGrade(new Grade("Cybersecurity", 4, 5, 19, 50, 8));
        } else if (index == 1) { // Layan
            addGrade(new Grade("OOP", 7, 18, 5, 40, 15));
            addGrade(new Grade("Logic Design", 3, 5, 18, 47, 9));
            addGrade(new Grade("Cybersecurity", 4, 5, 19, 50, 8));
        } else if (index == 2) { // Jana
            addGrade(new Grade("OOP", 5, 15, 5, 38, 17));
            addGrade(new Grade("Logic Design", 5, 5, 20, 45, 10));
            addGrade(new Grade("Cybersecurity", 4, 5, 19, 50, 8));
        }
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void removeCourse(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equalsIgnoreCase(name)) {
                courses.remove(i);
                break;
            }
        }
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addGrade(Grade g) {
        grades.add(g);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
    public String getDepartment() {
        return department;
    }

    public int getLevel() {
        return level;
    }


    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;

        double sum = 0;
        for (Grade g : grades) {
            sum += g.getGPA();
        }
        return sum / grades.size();
    }

    public String getOverallLetterGrade() {
        double gpa = calculateGPA();

        if (gpa >= 3.75) return "A+";
        else if (gpa >= 3.5) return "A";
        else if (gpa >= 3.0) return "B+";
        else if (gpa >= 2.5) return "B";
        else if (gpa >= 2.0) return "C+";
        else if (gpa >= 1.5) return "C";
        else if (gpa >= 1.0) return "D";
        else return "F";
    }

    public void showGrades() {
        System.out.println("\nYour Grade is : ");
        for (Grade g : grades) {
            System.out.println(g);
        }
        double gpa = calculateGPA();
        System.out.printf("GPA: %.2f (%s)\n", gpa, getOverallLetterGrade());
    }

    public void removeGrade(String courseName) {
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                grades.remove(i);
                break;
            }
        }
    }
}

