package com.jarl.customer.domain;

import lombok.Getter;

@Getter
public class PhoneException extends RuntimeException {
    private final String phone;

    public PhoneException(String message, String phone) {
        super(message);
        this.phone = phone;
    }
}
