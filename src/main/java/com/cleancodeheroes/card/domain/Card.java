package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

import java.util.Objects;

public class Card {
    private final CardId id;
    private final String name;
    private final Integer healthPoints ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;
    private final Integer level ;

    private Card (CardProps cardProps) {
        this.id = cardProps.Id();
        this.name = cardProps.Name();
        this.healthPoints = cardProps.HealthPoints();
        this.experiencePoints = cardProps.ExperiencePoints();
        this.power = cardProps.Power();
        this.armour = cardProps.Armour();
        this.specialty = cardProps.Specialty();
        this.rarity = cardProps.getRarity();
        this.level = cardProps.getLevel();
    }

    public static Card create (CardProps cardProps) { return new Card(cardProps); }

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

    public Rarity Rarity() {
        return rarity;
    }

    public Integer Level() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) {
            return false;
        };
        return id.equals(card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, healthPoints, experiencePoints, power, armour, specialty, rarity, level);
    }
}
