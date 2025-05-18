package com.jarl.account.infrastructure.repository.entity;

import com.jarl.account.domain.Money;
import com.jarl.account.domain.Movement;
import com.jarl.account.domain.MovementType;

public class MovementMapper {
    public static MovementEntity toEntity(Movement domain) {
        MovementEntity entity = new MovementEntity();
        entity.setId(domain.getId());
        entity.setDate(domain.getDate());
        entity.setMovementType(domain.getType().name());
        entity.setAmount(domain.getAmount().value());
        entity.setAvailableBalance(domain.getAvailableBalance().value());
        entity.setAccountNumber(domain.getAccountNumber());
        return entity;
    }

    public static Movement toDomain(MovementEntity entity) {
        return new Movement(
                entity.getId(),
                entity.getDate(),
                MovementType.valueOf(entity.getMovementType()),
                new Money(entity.getAmount()),
                new Money(entity.getAvailableBalance()),
                entity.getAccountNumber()
        );
    }
}
