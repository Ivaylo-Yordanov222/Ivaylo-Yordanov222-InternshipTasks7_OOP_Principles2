import java.util.ArrayList;
import java.util.List;

public class Class {
    private final String className;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Class(String className, List<Student> students, List<Teacher> teachers) {
        this.className = className;
        this.students = students;
        this.teachers = teachers;
    }

    public String getClassName() {
        return className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
