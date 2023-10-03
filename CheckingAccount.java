package BankGroupProject;
public class CheckingAccount extends BankAccount {

    private Double overdraftLimit;

    public CheckingAccount(Long accountNumber, String accountHolder, Double balance, Double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }



    public Double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(Double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }


    @Override
    public void deposit(Double amount) {
        super.setBalance(super.getBalance() + amount);
    }


    @Override
     void withdraw(Double amount) throws InsufficientFundsException{

        if(amount>(getBalance()+overdraftLimit))
            throw new InsufficientFundsException("Overdraft limit has been exceeded.");
        else
        setBalance(getBalance()-amount);

    }

    @Override
    public String toString() {
        return super.toString() +
                "overdraftLimit=" + overdraftLimit +
                '}';
    }
}
