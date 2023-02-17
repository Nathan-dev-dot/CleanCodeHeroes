package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class Power implements Characteristic {
    private final Integer power;

    public Power(Integer power) {
        this.power = power;
    }
    public Integer getPower() {
        return power;
    }

    @Override
    public Power increaseByFactor() {
        int newPowerPoint = (int) Math.abs(this.power * increaseFactor);
        return new Power(newPowerPoint);
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
