package BankAccount;

import BankAccount.Account;

public class Gambler extends Account {
    public Gambler(double initialBalance) {
        super(initialBalance);
    }

    @Override
    void charge() {}
    public void withdraw(double amount) {
        if (initialBalance > amount) {
            if (amount <= 0.49) {
                fee = 0;
            } else if (amount >= 0.51) {
                initialBalance -= amount * 2;
            } else {
                initialBalance -= amount;
            }
        }
    }
}
