import java.util.ArrayList;
import java.util.List;
public class Teacher extends Person{
    private  List<Discipline> disciplines = new ArrayList<>();

    public Teacher(String name, List<Discipline> disciplines) {
        super(name);
        this.disciplines = disciplines;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
}
