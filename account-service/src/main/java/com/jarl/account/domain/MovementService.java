package com.jarl.account.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class MovementService {
    public Movement generate(Account account, Money amount, MovementType type) {
        account.applyMovement(amount, type);

        return new Movement(
                UUID.randomUUID(),
                LocalDate.now(),
                type,
                amount,
                account.getBalance(),
                account.getAccountNumber()
        );
    }
}
