package model;

import java.util.Objects;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    private static int accountCounter = 0;

    // Constructor 1: No arguments
    public BankAccount() {
        this("Unknown", "0000", 0.0);
    }

    // Constructor 2: Holder and account number
    public BankAccount(String accountHolder, String accountNumber) {
        this(accountHolder, accountNumber, 0.0);
    }

    // Constructor 3: All fields
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder cannot be empty.");
        }

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        accountCounter++;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountCounter() {
        return accountCounter;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        // PLANTED BUG: incorrect comparison.
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount other)) {
            return false;
        }

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{accountHolder='" + accountHolder
                + "', accountNumber='" + accountNumber
                + "', balance=" + balance + "}";
    }
}