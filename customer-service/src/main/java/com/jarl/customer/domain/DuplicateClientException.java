package com.jarl.customer.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DuplicateClientException extends RuntimeException {
    private final String identification;
}
