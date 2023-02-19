package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

import java.util.Objects;

public final class Card {
    private final CardId id;
    private final HeroId parentHeroId;
    private final String name;
    private final HealthPoint healthPoints;
    private final ExperiencePoint experiencePoints ;
    private final Power power;
    private final Armour armour;
    private final Specialty specialty;
    private final Rarity rarity;
    private final Level level;

    public Card (CardProps cardProps) {
        this.id = cardProps.id;
        this.parentHeroId = cardProps.parentHeroId;
        this.name = cardProps.name;
        this.healthPoints = cardProps.healthPoints;
        this.experiencePoints = cardProps.experiencePoints;
        this.power = cardProps.power;
        this.armour = cardProps.armour;
        this.specialty = cardProps.specialty;
        this.rarity = cardProps.rarity;
        this.level = cardProps.level;
    }

    public CardId getId() {
        return id;
    }

    public HeroId getParentHeroId() {
        return parentHeroId;
    }

    public String getName() {
        return name;
    }

    public HealthPoint getHealthPoints() {
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
        return Objects.hash(id, parentHeroId, name, healthPoints, experiencePoints, power, armour, specialty, rarity, level);
    }
}
