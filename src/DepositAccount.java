public class DepositAccount extends Account{
    public DepositAccount(String owner, CustomerCode customerCode, AccountCode accountCode, double balance, double montlyInterestRate) {
        super(owner, customerCode, accountCode, balance, montlyInterestRate);
    }
    @Override
    public void withdraw(double amount){
        super.balance -= amount;
    }
}
