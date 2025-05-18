package com.jarl.account.application;

import com.jarl.account.domain.Movement;
import com.jarl.account.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GenerateReportUseCase {
    private final MovementRepository repo;

    public List<Movement> execute(String accountNumber, LocalDate from, LocalDate to) {
        return repo.findByAccountAndDateRange(accountNumber, from, to);
    }
}
