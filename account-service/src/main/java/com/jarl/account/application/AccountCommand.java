package com.jarl.account.application;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountCommand(
        String accountNumber,
        String accountType,
        BigDecimal balance,
        UUID clientId
) {}
