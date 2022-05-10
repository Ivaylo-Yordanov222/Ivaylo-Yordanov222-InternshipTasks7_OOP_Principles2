import java.time.LocalDateTime;

public class MediaContentFile extends ContentFile{

    public MediaContentFile(String name, String location, LocalDateTime creationDate, String content) {
        super(name, location, creationDate, content);
    }

    public void execute(){
        //266B
        //utf 0xE2 0x99 0xAB
        //(U+266B) (266B) (0xE2 0x99 0xAB)
        System.out.println("266B 266B 266B "+ getLocation() +"/" + getName() + "\n"+
                getContent());
    }
}
