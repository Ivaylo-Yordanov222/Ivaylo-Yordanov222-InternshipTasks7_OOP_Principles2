import java.util.ArrayList;
import java.util.List;
public final class Bank {
    private static List<Account> accountList = new ArrayList<>();

    public static void accountInfo(String[] commandLine) {
        Account info;
        if(isIBAN(commandLine[1])){
            info = findAccountByIBAN(commandLine[1]);
        }
        else{
            info = findAccount(commandLine[1]);
        }
        int period = Integer.parseInt(commandLine[2]);
        info.getInfo(period);
    }

    public static void withdrawAccount(String[] commandLine) {
        Account accountToWithdraw;
        if(isIBAN(commandLine[1])){
            accountToWithdraw = findAccountByIBAN(commandLine[1]);
        }
        else{
            accountToWithdraw = findAccount(commandLine[1]);
        }
        if(accountToWithdraw.getAccountCode() == AccountCode.DEPOSIT){
            double amount = Double.parseDouble(commandLine[2]);
            accountToWithdraw.withdraw(amount);
        }
    }

    public static void depositToAccount(String[] commandLine) {
        Account account;
        if(isIBAN(commandLine[1])){
            account = findAccountByIBAN(commandLine[1]);
        }
        else{
            account = findAccount(commandLine[1]);
        }

        double amount = Double.parseDouble(commandLine[2]);
        account.deposit(amount);
    }

    public static void openAccount(String[] commandLine) {
        String ownerName = commandLine[1];
        int customerChoice = Integer.parseInt(commandLine[2]);
        CustomerCode customerCode = CustomerCode.values()[customerChoice-1];
        int accountChoice = Integer.parseInt(commandLine[3]);
        AccountCode accountCode = AccountCode.values()[accountChoice-1];
        double balance = Double.parseDouble(commandLine[4]);
        double montlyInterestRate = Double.parseDouble(commandLine[5]);
        Account account = null;
        switch (accountCode){
            case DEPOSIT:
                account = new DepositAccount(ownerName,customerCode,accountCode,balance,montlyInterestRate);
                break;
            case LOAN:
                account = new LoanAccount(ownerName,customerCode,accountCode,balance,montlyInterestRate);
                break;
            case MORTGAGE:
                account = new MortgageAccount(ownerName,customerCode,accountCode,balance,montlyInterestRate);
                break;
        }
        Bank.accountList.add(account);
        System.out.println(account.getIban());
    }

    private static Account findAccount(String accountName){
        Account accountToFind = null;
        for (Account ac : Bank.accountList){
            if(ac.getOwner().equals(accountName)){
                accountToFind = ac;
                break;
            }
        }
        return  accountToFind;
    }
    private static Account findAccountByIBAN(String iban){
        Account accountToFind = null;
        for (Account ac : Bank.accountList){
            if(ac.getIban().equals(iban)){
                accountToFind = ac;
                break;
            }
        }
        return  accountToFind;
    }

    private static Boolean isIBAN(String ownerOrIban){
        try{
            int iban = Integer.parseInt(ownerOrIban);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
