public class Account {
    private static int id;
    private final int iban;
    private final String owner;
    protected CustomerCode customerCode;
    private final AccountCode accountCode;
    protected double balance;
    protected double montlyInterestRate;
    public Account(String owner, CustomerCode customerCode, AccountCode accountCode, double balance, double montlyInterestRate) {
        Account.id++;
        this.iban = id;
        this.owner = owner;
        this.customerCode = customerCode;
        this.accountCode = accountCode;
        this.balance = balance;
        this.montlyInterestRate = montlyInterestRate;
    }
    public String getOwner() {
        return owner;
    }
    public AccountCode getAccountCode() {
        return accountCode;
    }
    public String getIban() {
        return String.format("%08d",iban);
    }
    public void deposit(double amount){
        this.balance+=amount;
    }
    public void withdraw(double amount){

    }
    protected double interestForPeriod(int period){

        return (balance * (montlyInterestRate/100)) * period;
    }
    public void getInfo(int period){
        System.out.printf("%.2f%n",interestForPeriod(period));
    }
}
