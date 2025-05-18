package com.jarl.account.application;

import com.jarl.account.domain.Account;
import com.jarl.account.domain.AccountNotFound;
import com.jarl.account.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.jarl.account.common.Validations.validateNonNull;

@Component
@RequiredArgsConstructor
public class DeleteAccountUseCase {
    private final AccountRepository accountRepository;

    public void execute(String accountNumber) {
        validateNonNull("account number", accountNumber);

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFound(accountNumber));

        account.disable();
        accountRepository.save(account);
    }
}
