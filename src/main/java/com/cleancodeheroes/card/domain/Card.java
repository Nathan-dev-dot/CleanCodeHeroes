package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

import java.util.Objects;

public final class Card {
    private final CardId id;
    private final String name;
    private final Integer healthPoints;
    private final ExperiencePoint experiencePoints ;
    private final Power power;
    private final Armour armour;
    private final Specialty specialty;
    private final Rarity rarity;

    private final Level level;

    private Card (CardProps cardProps) {
        this.id = cardProps.id;
        this.name = cardProps.name;
        this.healthPoints = cardProps.healthPoints;
        this.experiencePoints = cardProps.experiencePoints;
        this.power = cardProps.power;
        this.armour = cardProps.armour;
        this.specialty = cardProps.specialty;
        this.rarity = cardProps.rarity;
        this.level = cardProps.level;
    }

    public static Card create (CardProps cardProps) { return new Card(cardProps); }

    public CardId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public ExperiencePoint getExperiencePoints() {
        return experiencePoints;
    }

    public Power getPower() {
        return power;
    }

    public Armour getArmour() {
        return armour;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Level getLevel() {
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
