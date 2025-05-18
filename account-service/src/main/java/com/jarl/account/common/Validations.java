package com.jarl.account.common;


import com.jarl.account.domain.AccountException;

import java.util.Objects;

public class Validations {
    public static void validateNonNull(String field, String value) {
        if (Objects.isNull(value)) {
            throw new AccountException("no acepta valores nulos", field);
        }
        if (value.isEmpty()) {
            throw new AccountException("no acepta valores nulos", field);
        }
    }

    public static void validateNonNull(String field, Object value) {
        if (Objects.isNull(value)) {
            throw new AccountException("no acepta valores nulos", field);
        }
    }
}
