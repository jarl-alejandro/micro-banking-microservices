package com.jarl.account.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal value) {

    public static final int SCALE = 2;

    public Money(BigDecimal value) {
        if (Objects.isNull(value )) {
            throw new MoneyException("El valor monetario no puede ser nulo.");
        }

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new MoneyException("El valor monetario no puede ser negativo.");
        }

        if (value.scale() > SCALE) {
            throw new MoneyException("El valor monetario no puede tener más de " + SCALE + " decimales.");
        }

        this.value = value.setScale(SCALE, RoundingMode.HALF_UP);
    }

    public Money add(Money amount) {
        return new Money(this.value.add(amount.value()));
    }

    public Money subtract(Money amount) {
        BigDecimal result = this.value.subtract(amount.value());
        if (result.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException(this.value, amount.value());
        }
        return new Money(result);
    }

    public Money applyMovement(Money amount, MovementType type) {
        return switch (type) {
            case DEPOSIT -> add(amount);
            case WITHDRAWAL -> subtract(amount);
        };
    }

    public boolean isGreaterThanOrEqual(BigDecimal amount) {
        return this.value.compareTo(amount) >= 0;
    }

    @Override
    public String toString() {
        return "$" + value.setScale(SCALE, RoundingMode.HALF_UP).toPlainString();
    }
}
