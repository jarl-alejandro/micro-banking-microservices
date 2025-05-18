package com.jarl.customer.domain;

public record Phone(String value) {
    public Phone {
        if (!value.matches("^09\\d{8}$")) {
            throw new PhoneException("Teléfono inválido", value);
        }
    }
}
