package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

public class CardProps {
    private final CardId id;
    private final String name;
    private final Integer healthPoints ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;
    private final Integer level ;

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
                card.Id(),
                card.Name(),
                card.HealthPoints(),
                card.ExperiencePoints(),
                card.Power(),
                card.Armour(),
                card.Specialty(),
                card.Rarity(),
                card.Level()
        );
    }

    public CardId Id() {
        return id;
    }

    public String Name() {
        return name;
    }

    public Integer HealthPoints() {
        return healthPoints;
    }

    public Integer ExperiencePoints() {
        return experiencePoints;
    }

    public Integer Power() {
        return power;
    }

    public Integer Armour() {
        return armour;
    }

    public Specialty Specialty() {
        return specialty;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Integer getLevel() {
        return level;
    }
}
