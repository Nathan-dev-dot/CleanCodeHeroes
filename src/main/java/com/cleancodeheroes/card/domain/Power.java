package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.utils.CharacteristicUtils;

import java.util.Objects;

public class Power implements Characteristic {
    private final Integer power;

    private Power(Integer power) {
        this.power = power;
    }

    public static Power of (Integer power) throws IllegalArgumentException {
        if (power < 0)
            throw new IllegalArgumentException();
        return new Power(power);
    }
    public Integer value() {
        return power;
    }

    @Override
    public Power increaseByFactor() {
        int newPowerPoint = CharacteristicUtils.increaseByFactor(this.power, increaseFactor);
        return Power.of(newPowerPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Power power1)) return false;
        return Objects.equals(value(), power1.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
