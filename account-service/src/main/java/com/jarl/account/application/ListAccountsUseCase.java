package com.jarl.account.application;

import com.jarl.account.domain.Account;
import com.jarl.account.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListAccountsUseCase {
    private final AccountRepository repo;

    public List<Account> execute() {
        return repo.find();
    }
}
