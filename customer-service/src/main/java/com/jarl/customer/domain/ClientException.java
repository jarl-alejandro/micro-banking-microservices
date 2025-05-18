package com.jarl.customer.domain;

import lombok.Getter;

@Getter
public class ClientException extends RuntimeException {
    private final String field;

    public ClientException(String message, String field) {
        super(message);
        this.field = field;
    }
}
