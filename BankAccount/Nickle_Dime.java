package BankAccount;


import BankAccount.Account;

public class Nickle_Dime extends Account {
    private final double fee=0.5;
    public Nickle_Dime(double initialBalance) {
        super(initialBalance);
    }

    @Override
    void charge() {
        initialBalance-=fee*transation_count;
    }@Override
    public void endMonth() {
        super.endMonth();
    }
}
