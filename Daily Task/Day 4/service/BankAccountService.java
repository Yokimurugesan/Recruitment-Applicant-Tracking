package service;

import model.BankAccount;

public class BankAccountService {

    public void deposit(BankAccount account, double amount) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        account.deposit(amount);
    }

    public void withdraw(BankAccount account, double amount) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        account.withdraw(amount);
    }

    public void displayAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        System.out.println(account);
    }
}