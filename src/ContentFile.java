import java.time.LocalDateTime;

public class ContentFile extends File{
    private String content;
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    public ContentFile(String name, String location, LocalDateTime creationDate, String content) {
        super(name, location, creationDate);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void modify(String data){
        lastModifiedDate = LocalDateTime.now();
        content = data;
    }

    public String getInfo(){
        return super.getInfo() +
                "Last modification date: " + getLastModifiedDate();
    }
}
