public class LoanAccount extends Account{
    public LoanAccount(String owner, CustomerCode customerCode, AccountCode accountCode, double balance, double montlyInterestRate) {
        super(owner, customerCode, accountCode, balance, montlyInterestRate);
    }
    @Override
    protected double interestForPeriod(int period){
        if(customerCode == CustomerCode.INDIVIDUAL){
            return (balance * (montlyInterestRate/100)) * (period - 3);
        }else{
            return (balance * (montlyInterestRate/100)) * (period - 2);
        }
    }
}
