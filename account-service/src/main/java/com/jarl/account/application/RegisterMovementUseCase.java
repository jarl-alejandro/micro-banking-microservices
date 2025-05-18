package com.jarl.account.application;

import com.jarl.account.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class RegisterMovementUseCase {
    private final AccountRepository accountRepo;
    private final MovementRepository movementRepo;
    private final MovementService domainService;

    public void execute(String accountNumber, BigDecimal amount, MovementType type) {
        Account account = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFound(accountNumber));

        Movement movement = domainService.generate(account, new Money(amount), type);

        accountRepo.save(account);
        movementRepo.save(movement);
    }
}
