package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class Armour {
    private final Integer armour;
    public Armour(Integer armour) {
        this.armour = armour;
    }

    public Armour addArmour(Integer armour) throws ArithmeticException {
        if (armour < 1){
            throw new ArithmeticException();
        }
        return new Armour(this.armour + armour);
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
