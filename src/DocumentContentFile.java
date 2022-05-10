import java.time.LocalDateTime;

public class DocumentContentFile extends ContentFile{

    public DocumentContentFile(String name, String location, LocalDateTime creationDate, String content) {
        super(name, location, creationDate, content);
    }

    public void execute(){
        //2713
        System.out.println("2713 2713 2713" + getLocation() +"/" + getName() + "\n"+
                getContent());
    }
}
