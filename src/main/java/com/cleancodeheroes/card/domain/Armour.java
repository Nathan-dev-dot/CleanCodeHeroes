package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class Armour implements Characteristic{
    private final Integer armour;
    public Armour(Integer armour) {
        this.armour = armour;
    }

    @Override
    public Armour increaseByFactor() {
        int newArmourPoint = (int) Math.abs(this.armour * increaseFactor);
        return new Armour(newArmourPoint);
    }
    public Integer getArmour() {
        return armour;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armour armour1)) return false;
        return Objects.equals(getArmour(), armour1.getArmour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArmour());
    }

}