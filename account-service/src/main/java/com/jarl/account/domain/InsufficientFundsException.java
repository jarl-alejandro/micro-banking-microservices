package com.jarl.account.domain;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    private final BigDecimal balance;
    private final BigDecimal amount;


    public InsufficientFundsException(BigDecimal balance, BigDecimal amount) {
        this.balance = balance;
        this.amount = amount;
    }
}
