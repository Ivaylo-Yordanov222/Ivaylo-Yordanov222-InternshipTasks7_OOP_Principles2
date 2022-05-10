public class Discipline {
    private final String name;
    private int hoursPerWeek;

    public Discipline(String name, int hoursPerWeek) {
        this.name = name;
        this.hoursPerWeek = hoursPerWeek;
    }

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
