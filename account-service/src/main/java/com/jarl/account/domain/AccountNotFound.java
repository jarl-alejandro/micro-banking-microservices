package com.jarl.account.domain;

import lombok.Getter;

@Getter
public class AccountNotFound extends RuntimeException {
    private final String accountNumber;

    public AccountNotFound(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
