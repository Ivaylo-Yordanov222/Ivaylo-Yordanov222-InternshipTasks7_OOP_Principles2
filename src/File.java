import java.time.LocalDateTime;

public class File {
    private final String name;
    private String location;
    private final LocalDateTime creationDate;
    protected boolean isDeleted;

    public File(String name, String location, LocalDateTime creationDate) {
        this.name = name;
        this.location = location;
        this.creationDate = LocalDateTime.now();
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void move(String newLocation){
        this.location = newLocation;
    }
    public File copy(String newLocation){
        return new File(this.name, newLocation,creationDate);
    }
    public void delete(){
        isDeleted = true;
    }
    public void execute(){

    }
    public String getInfo(){
        String isDel = isDeleted?"[[DELETED]]":"";
        return "Name: " + getLocation() +"/"+getName()+" "+ isDel+"\n"+
                "Creation date: " + getCreationDate()+"\n";
    }
}
