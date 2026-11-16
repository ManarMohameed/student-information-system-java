package project;

public class Material {
    private String name;
    private double mark;

    //Constructor
    public Material(String name, double mark) {
        this.name = name;
        setMark(mark); // نستخدم setter للتحقق من الصحة
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter & Setter Validation
    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
            System.out.println("Invalid mark! Must be between 0 and 100.");
        }
    }

    //toString
    public String toString() {
        return "Material: " + name + ", Mark: " + mark;
    }
}