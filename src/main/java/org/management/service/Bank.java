
package org.management.service;

import org.management.exception.failedTransactionException;
import org.management.model.Account;
import org.management.exception.AccountNotFoundException;
import org.management.exception.DuplicateAccountException;
import org.management.model.Transaction;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<Long, Account> accounts = new HashMap<>();
    private final Map<Long, Transaction> transactions = new HashMap<>();
    private long nextTransactionId = 1;

    public void createAccount(Account account) {

        long accountId = account.getAccountId();

        if (accounts.containsKey(accountId)) {
            throw new DuplicateAccountException(
                    "Account already exists: " + accountId
            );
        }

        accounts.put(accountId, account);
    }

    public Account getAccount(long accountId) {

        Account account = accounts.get(accountId);

        if (account == null) {
            throw new AccountNotFoundException(
                    "Account not found: " + accountId
            );
        }

        return account;
    }

    public void displayAccount(long accountId) {

        Account account = getAccount(accountId);

        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Name: " + account.getName());
        System.out.println("Balance: " + account.getBalance());
    }

    public void transfer(long fromAccountId, long toAccountId, int amount){

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Transfer amount must be greater than zero"
            );
        }

        if (fromAccountId == toAccountId) {
            throw new IllegalArgumentException(
                    "Cannot transfer money to the same account"
            );
        }

        Account fromAccount = getAccount(fromAccountId);
        Account toAccount = getAccount(toAccountId);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transaction transaction = new Transaction(nextTransactionId++, fromAccountId, toAccountId, amount, "COMPLETED");
        transactions.put(transaction.getTransactionId(), transaction);
    }

    public void displayTransactionHistory() {
        for (Transaction transaction : transactions.values()) {
            System.out.println(transaction);
        }
    }

}
