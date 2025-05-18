package com.jarl.account.domain;

import lombok.Getter;

@Getter
public class AccountException extends RuntimeException {
    private final String field;

    public AccountException(String message, String field) {
        super(message);
        this.field = field;
    }
}
