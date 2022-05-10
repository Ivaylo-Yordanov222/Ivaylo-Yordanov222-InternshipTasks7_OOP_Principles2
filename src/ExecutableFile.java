import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExecutableFile extends  File{
    private LocalDateTime lastExecutionDate = LocalDateTime.now();
    private List<File> requiredResources = new ArrayList<>();

    public ExecutableFile(String name, String location, LocalDateTime creationDate, List<File> requiredResources) {
        super(name, location, creationDate);
        this.requiredResources =requiredResources;
    }
    public LocalDateTime getLastExecutionDate() {
        return lastExecutionDate;
    }

    public List<File> getRequiredResources() {
        return requiredResources;
    }

    public void execute(){
        lastExecutionDate = LocalDateTime.now();
        System.out.println("Executing "+ getLocation()+"/"+getName());
        for (File f : requiredResources){
            if(!f.isDeleted){
                f.execute();
            }
        }
    }

    public String getInfo(){
        return super.getInfo() +
                "Last execution date: " + getLastExecutionDate()+"\n"
                +"Required resources: \n"
                 + requiredResourcesString();
    }
    private String requiredResourcesString(){
        StringBuilder resources = new StringBuilder();
        for (File r : getRequiredResources()){
            resources.append(r.getName());
            resources.append("\n");
        }
        resources.setLength(resources.length() - 1);
        return  resources.toString();
    }
}
