package org.management.exception;

public class failedTransactionException extends RuntimeException{
    public failedTransactionException(String message){
        super(message);
    }
}
