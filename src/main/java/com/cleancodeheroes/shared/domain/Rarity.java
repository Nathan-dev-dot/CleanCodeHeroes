package com.cleancodeheroes.shared.domain;

import java.util.Objects;

public final class Rarity {
    private final Rarities rarity ;

    public Rarity(String rarity) throws IllegalArgumentException {
        this.rarity = this.rarityFromString(rarity);
    }

    private Rarities rarityFromString (String value) {
        return Rarities.valueOf(value);
    }

    public Rarities value() {
        return rarity;
    }

    @Override
    public String toString () {
        return rarity.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rarity rarity1)) return false;
        return rarity == rarity1.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(rarity);
    }
}