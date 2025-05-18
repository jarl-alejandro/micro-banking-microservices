package com.jarl.account.domain;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findByAccountNumber(String number);
    void save(Account account);

    List<Account> find();
}
