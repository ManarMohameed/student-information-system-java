package project;

import java.util.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Teacher teacher = new Teacher();
        Student st = new Student(teacher);
        Attendance absence = new Attendance();
        // الحذف و الإضافة
        DeletioonAndAddition subjectManager = new DeletioonAndAddition();

        // Create teachers
        Teacher t1 = new Teacher();
        t1.setName("Ohood");
        t1.setId(10);
        Teacher.addTeacher(t1);

        Teacher t2 = new Teacher();
        t2.setName("Raghda");
        t2.setId(20);
        Teacher.addTeacher(t2);

        Teacher t3 = new Teacher();
        t3.setName("Amal");
        t3.setId(30);
        Teacher.addTeacher(t3);

        // Create students
        Student s1 = new Student();
        s1.setName("Manar");
        s1.setId(101);
        Student.addStudent(s1);

        Student s2 = new Student();
        s2.setName("Layan");
        s2.setId(102);
        Student.addStudent(s2);

        Student s3 = new Student();
        s3.setName("Jana");
        s3.setId(103);
        Student.addStudent(s3);

        // Enter Student Name
        while (true) {
            System.out.print("Enter student name: ");
            String name = keyboard.nextLine();
            int index = st.searchStudent(name); // البحث عن اسم الطالب في قائمة الطلاب

            if (index != -1) {

                st.StudentInfo(index);

                // Load attendance correctly
                absence.setDefaultAttendance();

                System.out.println("\nStudent Information");
                System.out.println("Name: " + st.getName());
                System.out.println("ID: " + st.getId());
                System.out.println("Department: " + st.getDepartment());
                System.out.println("Level: " + st.getLevel());
                System.out.print("Courses: ");
                for (Course c : st.getCourses()) System.out.print(c.getName() + " ");
                System.out.println();
                System.out.println("Teachers: " + Arrays.toString(Teacher.getTeacherNames()));

                boolean continueMenu = true;
                while (continueMenu) {

                    System.out.println("\nChoose the section number you want to display: ");
                    System.out.println("1- Attendance");
                    System.out.println("2- Deletion and Addition");
                    System.out.println("3- Teachers");
                    System.out.println("4- Grade");
                    System.out.println("5- Exit");
                    System.out.print("Enter choice: ");

                    int choice = keyboard.nextInt();
                    keyboard.nextLine();

                    switch (choice) {

                        case 1:
                            System.out.println("\nAttendance Section: ");
                            absence.showAttendance(st.getId());
                            absence.showAbsenceSummary(st.getId());
                            break;

                        case 2: // الحذف و الإضافة
                            subjectManager.start(st); // الطالب
                            break;

                        case 3:
                            System.out.println("\nTeacher Information: ");
                            System.out.println("1- Show all teachers");
                            System.out.println("2- Search teacher by name");
                            System.out.print("Enter choice: ");
                            int tChoice = keyboard.nextInt();
                            keyboard.nextLine();

                            if (tChoice == 1) {
                                for (int i = 0; i < Teacher.getTeacherNames().length; i++) {
                                    teacher.TeacherInfo(i);
                                    System.out.println("Name: " + Teacher.getTeacherNames()[i] +
                                                       " | ID: " + Teacher.getTeacherIds()[i] +
                                                       " | Teaching: " + teacher.getMaterial() +
                                                       " | Qualification: " + teacher.getQualification());
                                }
                            } else if (tChoice == 2) {
                                System.out.print("Enter teacher name to search: ");
                                String tname = keyboard.nextLine();
                                String foundTeacher = teacher.searchTeacher(tname);

                                if (foundTeacher.equals("Teacher not found!")) {
                                    System.out.println("Teacher not found!");
                                } else {
                                    for (int i = 0; i < Teacher.getTeacherNames().length; i++) {
                                        if (Teacher.getTeacherNames()[i].equalsIgnoreCase(foundTeacher)) {
                                            teacher.TeacherInfo(i);
                                            System.out.println("Name: " + foundTeacher +
                                                               " | ID: " + Teacher.getTeacherIds()[i] +
                                                               " | Teaching: " + teacher.getMaterial() +
                                                               " | Qualification: " + teacher.getQualification());
                                            break;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Invalid choice!");
                            }
                            break;

                        case 4:
                            System.out.println("\nYour grade is: ");
                            for (Grade g : st.getGrades())
                                System.out.println(g.toString());
                            double gpa = st.calculateGPA();
                            System.out.printf("GPA: %.2f (%s)\n", gpa, st.getOverallLetterGrade());
                            break;

                        case 5:
                            continueMenu = false;
                            System.out.println("\nThank you for using our system!");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                    if (choice != 5) {
                        System.out.print("\nDo you want to go back to section? (yes/no): ");
                        String again = keyboard.nextLine();
                        if (!again.equalsIgnoreCase("yes")) {
                            continueMenu = false;
                            System.out.println("\nThank you for using our system!");
                        }
                    }
                }
                break;
            } else {
                System.out.println("Name not registered! Try again...");
            }
        }

        keyboard.close();
    }
}