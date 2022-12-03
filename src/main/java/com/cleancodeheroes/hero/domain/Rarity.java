package com.cleancodeheroes.hero.domain;

public class Rarity {

    public enum Rarities {
        Common,
        Rare,
        Legendary
    }

    public String rarityAsString (Rarity rarity) {
        return rarity.toString();
    }
}