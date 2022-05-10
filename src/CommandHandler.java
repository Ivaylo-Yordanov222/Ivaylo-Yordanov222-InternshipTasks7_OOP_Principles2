import java.util.Scanner;
public final class CommandHandler {
    static String row;
    static String[] commandLine;
    public static void ececuteCommand(Scanner scanner){
        while(!((row = scanner.nextLine()).trim().equals("END"))){
            commandLine = row.trim().split(" ");
            String command = commandLine[0];
            switch (command){
                case "MAKE":
                    FileManager.makeFile(commandLine);
                    break;
                case "MOVE":
                    FileManager.moveFile(commandLine);
                    break;
                case "COPY":
                    File copiedFile = FileManager.copyFile(commandLine);
                    break;
                case "DEL":
                    FileManager.deleteFile(commandLine);
                    break;
                case "EXEC":
                    FileManager.executeFile(commandLine);
                    break;
                case "INFO":
                    FileManager.infoFile(commandLine);
                    break;
                case "MOD":
                    FileManager.modifyFile(commandLine);
                    break;
            }
        }
    }
}
