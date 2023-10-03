package BankGroupProject;

public class SavingsAccount extends BankAccount implements InterestRate{

      private  Double interestRate;

    public SavingsAccount(Long accountNumber, String accountHolder, Double balance, Double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
   public Double calculateInterest() {
        return interestRate * super.getBalance();
    }

   @Override
   public void deposit(Double amount){
        super.setBalance(super.getBalance()+amount);
   }

    @Override
    public void withdraw(Double amount){
        if(amount>getBalance())
            throw new InsufficientFundsException("withdrawal limit has been exceeded.");
        else
            super.setBalance(super.getBalance()-amount);
    }

    @Override
    public String toString() {
        return super.toString() +
                "interestRate=" + interestRate +
                '}';
    }
}
