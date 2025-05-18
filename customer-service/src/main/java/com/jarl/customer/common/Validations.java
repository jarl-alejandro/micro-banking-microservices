package com.jarl.customer.common;

import com.jarl.customer.domain.ClientException;

import java.util.Objects;

public class Validations {
    public static void validateNonNull(String field, String value) {
        if (Objects.isNull(value)) {
            throw new ClientException("no acepta valores nulos", field);
        }
        if (value.isEmpty()) {
            throw new ClientException("no acepta valores nulos", field);
        }
    }

    public static void validateNonNull(String field, Object value) {
        if (Objects.isNull(value)) {
            throw new ClientException("no acepta valores nulos", field);
        }
    }
}
