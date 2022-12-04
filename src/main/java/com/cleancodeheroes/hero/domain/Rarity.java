package com.cleancodeheroes.hero.domain;

public class Rarity {
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
}