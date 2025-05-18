package com.jarl.account.infrastructure.repository.entity;

import com.jarl.account.domain.Account;
import com.jarl.account.domain.Money;

public class AccountMapper {
    public static AccountEntity toEntity(Account domain) {
        AccountEntity entity = new AccountEntity();
        entity.setAccountNumber(domain.getAccountNumber());
        entity.setAccountType(domain.getAccountType());
        entity.setBalance(domain.getBalance().value());
        entity.setActive(domain.isActive());
        entity.setClientId(domain.getClientId());
        return entity;
    }

    public static Account toDomain(AccountEntity entity) {
        return new Account(
                entity.getAccountNumber(),
                entity.getAccountType(),
                new Money(entity.getBalance()),
                entity.isActive(),
                entity.getClientId()
        );
    }
}
