package com.jarl.account.application;

import com.jarl.account.domain.Account;
import com.jarl.account.domain.AccountNotFound;
import com.jarl.account.domain.AccountRepository;
import com.jarl.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.jarl.account.common.Validations.validateNonNull;

@Component
@RequiredArgsConstructor
public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;

    public void execute(String accountNumber, AccountCommand command) {
        validateNonNull("account number", command.accountNumber());
        validateNonNull("account type", command.accountType());
        validateNonNull("balance", command.balance());
        validateNonNull("client id", command.clientId());

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFound(accountNumber));

        account.update(
                command.accountNumber(),
                command.accountType(),
                new Money(command.balance()),
                command.clientId()
        );
        accountRepository.save(account);
    }
}
