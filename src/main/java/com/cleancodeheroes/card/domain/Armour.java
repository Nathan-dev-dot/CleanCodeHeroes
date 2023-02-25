package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.utils.CharacteristicUtils;

import java.util.Objects;

public class Armour implements Characteristic{
    private final Integer armour;
    private Armour(Integer armour) {
        this.armour = armour;
    }
    
    public static Armour of(Integer armour) throws IllegalArgumentException{
        if (armour < 0)
            throw new IllegalArgumentException();
        return new Armour(armour);
    }

    @Override
    public Armour increaseByFactor() throws ArithmeticException {
        int newArmourPoint = CharacteristicUtils.increaseByFactor(this.armour, increaseFactor);
        return Armour.of(newArmourPoint);
    }
    public Integer value() {
        return armour;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armour armour1)) return false;
        return Objects.equals(value(), armour1.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

}
