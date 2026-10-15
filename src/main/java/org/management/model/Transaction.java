package org.management.model;

public class Transaction {

    private long transactionId;
    private long fromAccountId;
    private long toAccountId;
    private int amount;
    private String status;

    public Transaction(long transactionId, long fromAccountId, long toAccountId, int amount, String status) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

    public long getTransactionId() {
        return transactionId;
    }

    public long getFromAccountId() {
        return fromAccountId;
    }

    public long getToAccountId() {
        return toAccountId;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}
