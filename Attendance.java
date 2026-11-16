package project;
import java.io.*;

public class Attendance {

    enum Weekday {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY
    }

    // 3 students × 5 days
    private boolean[][] attendance = new boolean[3][5];

    // Convert student ID
    private int getIndexById(long id) {
        if (id == 101) return 0; 
        if (id == 102) return 1; 
        if (id == 103) return 2;
        return -1;
    }

    // Create the attendance file
    public void generateAttendanceFile() {
        try (PrintWriter output = new PrintWriter("attendance.txt")) {

            // Manar
            output.println("101,SUNDAY,true");
            output.println("101,MONDAY,true");
            output.println("101,TUESDAY,true");
            output.println("101,WEDNESDAY,true");
            output.println("101,THURSDAY,true");

            // Layan
            output.println("102,SUNDAY,true");
            output.println("102,MONDAY,false");
            output.println("102,TUESDAY,true");
            output.println("102,WEDNESDAY,true");
            output.println("102,THURSDAY,true");

            // Jana
            output.println("103,SUNDAY,true");
            output.println("103,MONDAY,false");
            output.println("103,TUESDAY,true");
            output.println("103,WEDNESDAY,true");
            output.println("103,THURSDAY,false");

        } catch (Exception e) {
            System.out.println("Error creating file!");
        }
    }

    // Read attendance from file
    public void loadAttendanceFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                long id = Long.parseLong(parts[0]);
                Weekday day = Weekday.valueOf(parts[1]);
                boolean present = Boolean.parseBoolean(parts[2]);

                int index = getIndexById(id);
                if (index != -1)
                    attendance[index][day.ordinal()] = present;
            }

        } catch (Exception e) {
            System.out.println("Error loading attendance: " + e.getMessage());
        }
    }

    //Test calling
    public void setDefaultAttendance() {
        generateAttendanceFile();
        loadAttendanceFromFile("attendance.txt");
    }

    // Show Attendance Table
    public void showAttendance(long id) {
        int index = getIndexById(id);
        if (index == -1) return;

        System.out.println("Attendance Table");
        for (Weekday day : Weekday.values()) {
            boolean present = attendance[index][day.ordinal()];
            System.out.println(day + " - " + (present ? "Present" : "Absent"));
        }
    }

    // Show absence percentage
    public void showAbsenceSummary(long id) {
        int index = getIndexById(id);
        if (index == -1) return;

        int total = Weekday.values().length;
        int absent = 0;

        for (Weekday day : Weekday.values()) {
            if (!attendance[index][day.ordinal()])
                absent++;
        }

        double rate = (absent * 100.0) / total;

        System.out.println("\nAbsence Summary:");
        System.out.println("Total Absences: " + absent + "/" + total);
        System.out.printf("Absence Percentage: %.2f%%\n", rate);

        if (rate >= 25)
            System.out.println("WARNING: Absences exceeded 25%!");
        else if (rate >= 15)
            System.out.println("NOTICE: Absences exceeded 15%!");
        else
            System.out.println("Attendance is good.");
    }
}
