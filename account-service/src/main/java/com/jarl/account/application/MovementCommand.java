package com.jarl.account.application;

import com.jarl.account.domain.MovementType;

import java.math.BigDecimal;

public record MovementCommand(
        String accountNumber,
        BigDecimal amount,
        MovementType type
) {}