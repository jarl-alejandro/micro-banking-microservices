package com.jarl.account.infrastructure.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, UUID> {
    List<MovementEntity> findByAccountNumberAndDateBetween(String accountNumber, LocalDate from, LocalDate to);
}