package org.management;


import org.management.model.Account;
import org.management.service.Bank;

public class App
{
    public static void main( String[] args )
    {
        Account account = new Account(
                101L, "Jay", "1234567890", "Bhopal"
        );

        account.deposit(1000);

        Thread t1 = new Thread(() -> {
            try {
                account.withdraw(700);
                System.out.println("Thread 1: Withdrawal successful");
            } catch (Exception e) {
                System.out.println("Thread 1: " + e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                account.withdraw(700);
                System.out.println("Thread 2: Withdrawal successful");
            } catch (Exception e) {
                System.out.println("Thread 2: " + e.getMessage());
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
