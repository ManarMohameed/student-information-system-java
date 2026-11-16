package project;

public class Grade {
    
    private String courseName;
    private double quiz;
    private double mid;
    private double assignments;
    private double finalExam;
    private double project;


    public Grade(String courseName, double quiz, double mid, double assignments, double finalExam, double project) {
        this.courseName = courseName;
        this.quiz = quiz;
        this.mid = mid;
        this.assignments = assignments;
        this.finalExam = finalExam;
        this.project = project;
    }
    
    public String getCourseName() { return courseName; }


    // Total mark calculation
    public double getTotal() {
        return quiz + mid + assignments + finalExam + project;
    }

    // Convert mark to Grade
    public String getLetterGrade() {
        double total = getTotal();

        if (total >= 95) return "A+";
        else if (total >= 90) return "A";
        else if (total >= 85) return "B+";
        else if (total >= 80) return "B";
        else if (total >= 75) return "C+";
        else if (total >= 70) return "C";
        else if (total >= 60) return "D";
        else return "F";
    }

    // Grade points for GPA (4.0 scale)
    public double getGPA() {
        String grade = getLetterGrade();

        switch (grade) {
            case "A+": return 4.0;
            case "A":  return 3.75;
            case "B+": return 3.5;
            case "B":  return 3.0;
            case "C+": return 2.5;
            case "C":  return 2.0;
            case "D+":  return 1.5;
            case "D":  return 1.0;
            default:   return 0.0;
        }
    }

    public String toString() {
        return courseName + ": " + getTotal() + " (" + getLetterGrade() + ")";
    }
}
