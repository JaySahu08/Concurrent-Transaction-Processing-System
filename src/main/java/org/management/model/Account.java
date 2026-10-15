
package org.management.model;

import org.management.exception.InsufficientBalanceException;

public class Account {

    private long accountId;
    private String name;
    private String contact;
    private String address;
    private int balance;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(long accountId, String name, String contact, String address) {
        this.accountId = accountId;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.balance = 0;
    }

    public Account(Account acc){
        accountId = getAccountId();
        accountId = acc.getAccountId();
        name = acc.getName();
        contact = acc.getContact();
        address = acc.getAddress();
        balance = acc.getBalance();

    }

    public long getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be greater than zero"
            );
        }

        balance += amount;
        return balance;
    }

    public synchronized int withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        balance -= amount;
        return balance;
    }
}
