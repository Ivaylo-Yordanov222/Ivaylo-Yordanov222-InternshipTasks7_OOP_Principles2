public class Student extends Person {

    private final String facultyNumber;
    private final String className;

    public Student(String name, String facultyNumber, String className) {
        super(name);
        this.facultyNumber = facultyNumber;
        this.className = className;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public String getClassName() {
        return className;
    }
}
