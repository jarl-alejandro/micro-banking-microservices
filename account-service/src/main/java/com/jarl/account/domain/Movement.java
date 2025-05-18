package com.jarl.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Movement {
    private UUID id;
    private LocalDate date;
    private MovementType type;
    private Money amount;
    private Money availableBalance;
    private String accountNumber;
}
