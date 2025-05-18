package com.jarl.account.domain;

import java.time.LocalDate;
import java.util.List;

public interface MovementRepository {
    void save(Movement movement);
    List<Movement> findByAccountAndDateRange(String accountNumber, LocalDate from, LocalDate to);
}