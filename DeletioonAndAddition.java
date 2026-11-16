package project;

import java.util.Scanner;

public class DeletioonAndAddition{

    private Scanner input = new Scanner(System.in);

    private final String[] removableSubjects = {"Logic Design", "OOP", "Cybersecurity"};
    private final String[] addableSubjects = {"Biology", "Chemistry", "Data Structures", "Physics"};

    // Method موحدة لعرض الخيارات وتنفيذ إضافة/حذف
    void manageSubject(Student student) {

        while (true) {

            System.out.println("\nSubject Management:");
            System.out.println("1- Delete Subject");
            System.out.println("2- Add Subject");
            System.out.println("3- Back");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    deleteProcess(student);
                    break;

                case 2:
                    addProcess(student);
                    break;

                case 3:
                    return; // خروج من إدارة المواد

                default:
                    System.out.println("Invalid choice!");
            }

            showCurrentCourses(student);
        }
    }

    private void deleteProcess(Student student) {
        System.out.println("\nWhich subject do you want to delete?");
        for (int i = 0; i < removableSubjects.length; i++) {
            System.out.println((i + 1) + "- " + removableSubjects[i]);
        }
        System.out.println((removableSubjects.length + 1) + "- None");

        int choice = input.nextInt();
        input.nextLine();

        if (choice >= 1 && choice <= removableSubjects.length) {
            String subject = removableSubjects[choice - 1];
            student.removeCourse(subject);
            student.removeGrade(subject);
            System.out.println("Subject deleted: " + subject);
        } else {
            System.out.println("No subject was deleted.");
        }
    }

    private void addProcess(Student student) {
        System.out.println("\nWhich subject do you want to add?");
        for (int i = 0; i < addableSubjects.length; i++) {
            System.out.println((i + 1) + "- " + addableSubjects[i]);
        }

        int choice = input.nextInt();
        input.nextLine();

        if (choice >= 1 && choice <= addableSubjects.length) {
            String subject = addableSubjects[choice - 1];

            student.addCourse(new Course(subject));
            student.addGrade(new Grade(subject, 0, 0, 0, 0, 0));

            System.out.println("Subject added: " + subject);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private void showCurrentCourses(Student student) {
        System.out.print("\nCurrent Courses: ");
        for (Course c : student.getCourses()) {
            System.out.print(c.getName() + " ");
        }
        System.out.println();
    }

    // Start
    public void start(Student student) {
        while (true) {

            manageSubject(student);

            System.out.println("\nYour data has been updated. Thank you!");
            System.out.println("Do you want to edit another section? (yes/no)");

            if (!input.nextLine().equalsIgnoreCase("yes")) 
                break;
            }
        }
    }
