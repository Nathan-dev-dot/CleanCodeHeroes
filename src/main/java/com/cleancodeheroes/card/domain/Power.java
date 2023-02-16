package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class Power {
    private final Integer power;

    public Power(Integer power) {
        this.power = power;
    }
    public Integer getPower() {
        return power;
    }

    public Power addPower(Integer power) {
        if (power < 1){
            throw new ArithmeticException();
        }
        return new Power(this.power + power);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Power power1)) return false;
        return Objects.equals(getPower(), power1.getPower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPower());
    }
}
