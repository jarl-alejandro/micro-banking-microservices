package com.jarl.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Account {
    private String accountNumber;
    private String accountType;
    private Money balance;
    private boolean active;
    private UUID clientId;

    public void applyMovement(Money amount, MovementType type) {
        this.balance = balance.applyMovement(amount, type);
    }

    public void update(String accountNumber, String accountType, Money balance, UUID clientId) {
        this.accountNumber =  accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.clientId = clientId;
    }

    public void disable() {
        this.active = false;
    }
}
