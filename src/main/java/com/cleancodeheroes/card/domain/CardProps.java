package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

public final class CardProps {
    public final CardId id;
    public final String name;
    public final Integer healthPoints ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final Specialty specialty;
    public final Rarity rarity ;
    public final Integer level ;

    public CardProps(
            CardId id,
            String name,
            Integer healthPoints,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            Specialty specialty,
            Rarity rarity,
            Integer level) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.power = power;
        this.armour = armour;
        this.specialty = specialty;
        this.rarity = rarity;
        this.level = level;
    }

    public static CardProps of(Card card) {
        return new CardProps (
                card.getId(),
                card.getName(),
                card.getHealthPoints(),
                card.getExperiencePoints(),
                card.getPower(),
                card.getArmour(),
                card.getSpecialty(),
                card.getRarity(),
                card.getLevel()
        );
    }
}
