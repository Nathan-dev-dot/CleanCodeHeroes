package com.cleancodeheroes.hero.domain;

public class Rarity {
    public final Rarities rarity ;

    public Rarity(String rarity) {
        this.rarity = this.rarityFromString(rarity);
    }

    private Rarities rarityFromString (String value) {
        return Rarities.valueOf(value);
    }

    @Override
    public String toString () {
        return rarity.toString();
    }
}