public class MortgageAccount extends Account{
    public MortgageAccount(String owner, CustomerCode customerCode, AccountCode accountCode, double balance, double montlyInterestRate) {
        super(owner, customerCode, accountCode, balance, montlyInterestRate);
    }
    @Override
    protected double interestForPeriod(int period){
        if(customerCode == CustomerCode.INDIVIDUAL){
            return (balance * (montlyInterestRate/100)) * (period - 6);
        }else{
            double rateForMonth = (balance * (montlyInterestRate/100));
            if(period <=12){
                return rateForMonth*0.5 * period;
            }else{
                int remainder = period - 12;
                return ((rateForMonth*0.5) * 12) + rateForMonth * remainder;
            }
        }
    }
}
