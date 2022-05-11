import java.util.Scanner;

public final class CommandHandler {
    public static void executeCommand(Scanner scanner){
        String row;
        String[] commandLine;
        while(!((row = scanner.nextLine()).trim().equals("END"))){
            commandLine = row.trim().split(" ");
            String command = commandLine[0];
            switch (command){
                case "OPEN":
                    Bank.openAccount(commandLine);
                    break;
                case "PUT":
                    Bank.depositToAccount(commandLine);
                    break;
                case "GET":
                    Bank.withdrawAccount(commandLine);
                    break;
                case "INFO":
                    Bank.accountInfo(commandLine);
                    break;
            }
        }
    }
}
