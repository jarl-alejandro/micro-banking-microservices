package com.jarl.customer.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientNotFountException extends RuntimeException {
    private final String identification;
}
