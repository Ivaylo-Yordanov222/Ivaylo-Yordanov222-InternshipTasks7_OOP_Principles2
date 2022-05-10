import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class FileManager {
    private final static List<File> files = new ArrayList<>();
    private static final String  CONTENT = "CONTENT";

    public static void modifyFile(String[] commandLine) {
        File fileToModify = findFile(commandLine[1]);
        ((ContentFile) fileToModify).modify(commandLine[2]);
    }

    public static void executeFile(String[] commandLine) {
        File fileToExecute = findFile(commandLine[1]);
        fileToExecute.execute();
    }

    public static void deleteFile(String[] commandLine) {
        File fileToDelete = findFile(commandLine[1]);
        fileToDelete.delete();
    }

    public static File copyFile(String[] commandLine) {
        File fileToCopy = findFile(commandLine[1]);
        return fileToCopy.copy(commandLine[2]);
    }

    public static void infoFile(String[] commandLine) {
        File infoFile = findFile(commandLine[1]);
        System.out.println(infoFile.getInfo());
    }

    public static void moveFile(String[] commandLine) {
        File fileToMove = findFile(commandLine[1]);

        fileToMove.move(commandLine[2]);
    }

    public static void makeFile(String[] commandLine) {
        File file;
        String name = commandLine[1];
        String fileLocation = commandLine[2];
        //Content file
        if(commandLine[3].contains(CONTENT)){
            //this is content file
            String[] contentRow = commandLine[3].split("=");
            String content = contentRow[1];
            if(name.endsWith(".avi") || name.endsWith(".mp3")){
                //This is media file
                file = new MediaContentFile(name,fileLocation, LocalDateTime.now(),content);
            }
            else{
                //this is document file
                file = new DocumentContentFile(name, fileLocation, LocalDateTime.now(), content);
            }
        }
        else{
            //Executable file
            List<File> resources = new ArrayList<>();
            fillResources(commandLine, resources);
            file = new ExecutableFile(name,fileLocation, LocalDateTime.now(),resources);
        }
        files.add(file);
    }

    public static void fillResources(String[] commandLine, List<File> resources) {
        for(int i = 3; i< commandLine.length; i++){
            File fileToAdd = findFile(commandLine[i]);
            resources.add(fileToAdd);
        }
    }

    public static File findFile(String fileName){
        File searchedFile = null;
        for (File f : files){
            if(f.getName().equals(fileName)){
                searchedFile = f;
            }
        }
        return searchedFile;
    }
}
