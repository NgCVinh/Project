package BankAccount;

import BankAccount.Account;

public class Fee extends Account {
    private final double fee=5.00;

    public Fee(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void charge() {
        initialBalance-=fee;
    }

}
