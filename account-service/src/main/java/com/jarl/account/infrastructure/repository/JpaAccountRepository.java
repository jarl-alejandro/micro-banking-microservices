package com.jarl.account.infrastructure.repository;

import com.jarl.account.domain.Account;
import com.jarl.account.domain.AccountRepository;
import com.jarl.account.infrastructure.repository.entity.AccountJpaRepository;
import com.jarl.account.infrastructure.repository.entity.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaAccountRepository implements AccountRepository {
    private final AccountJpaRepository jpa;

    @Override
    public Optional<Account> findByAccountNumber(String number) {
        return jpa.findById(number).map(AccountMapper::toDomain);
    }

    @Override
    public void save(Account account) {
        jpa.save(AccountMapper.toEntity(account));
    }

    @Override
    public List<Account> find() {
        return jpa.findAll().stream()
                .map(AccountMapper::toDomain)
                .toList();
    }
}
