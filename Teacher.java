package project;
import java.util.ArrayList;

public class Teacher extends Person {

    private String Material;
    private String qualification;

    // list of teachers
    private static ArrayList<Teacher> teachersList = new ArrayList<>();

    public static void addTeacher(Teacher t) {
        teachersList.add(t);
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        this.Material = material;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification ) {
        this.qualification=qualification;
    }
    

    // Search for teacher by name
    public String searchTeacher(String name) {
        for (Teacher t : teachersList) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t.getName();
            }
        }
        return "Teacher not found!";
    }

    // Teacher Info
    public void TeacherInfo(int index) {
        Teacher t = teachersList.get(index);

        setName(t.getName());
        setId(t.getId());

        if (index == 0) {
            this.Material = "OOP";
            this.qualification = "Master";
        } else if (index == 1) {
            this.Material = "Logic Design";
            this.qualification = "Master";
        } else if (index == 2) {
            this.Material = "Cybersecurity";
            this.qualification = "Master";
        }
    }

    public static String[] getTeacherNames() {
        String[] arr = new String[teachersList.size()];
        for (int i = 0; i < teachersList.size(); i++) {
            arr[i] = teachersList.get(i).getName();
        }
        return arr;
    }

    public static int[] getTeacherIds() {
        int[] arr = new int[teachersList.size()];
        for (int i = 0; i < teachersList.size(); i++) {
            arr[i] = (int) teachersList.get(i).getId();
        }
        return arr;
    }
}
