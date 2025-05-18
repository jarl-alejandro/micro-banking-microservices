package com.jarl.account.infrastructure.repository;

import com.jarl.account.domain.Movement;
import com.jarl.account.domain.MovementRepository;
import com.jarl.account.infrastructure.repository.entity.MovementJpaRepository;
import com.jarl.account.infrastructure.repository.entity.MovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaMovementRepository implements MovementRepository {

    private final MovementJpaRepository jpa;


    @Override
    public void save(Movement movement) {
        jpa.save(MovementMapper.toEntity(movement));
    }

    @Override
    public List<Movement> findByAccountAndDateRange(String accountNumber, LocalDate from, LocalDate to) {
        return jpa.findByAccountNumberAndDateBetween(accountNumber, from, to)
                .stream()
                .map(MovementMapper::toDomain)
                .toList();
    }
}
