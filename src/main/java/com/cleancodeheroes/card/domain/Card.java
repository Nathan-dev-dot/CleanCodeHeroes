package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;
import com.cleancodeheroes.user.domain.UserId;

import java.util.Objects;

public final class Card {
    private final CardId id;
    private final HeroId parentHeroId;
    private final String name;
    private HealthPoint healthPoints;
    private ExperiencePoint experiencePoints ;
    private Power power;
    private Armour armour;
    private final Specialty specialty;
    private final Rarity rarity;
    private Level level;
    private final UserId userId;
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
        this.userId = cardProps.userId;
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

    public UserId getUserId() {
        return userId;
    }


    public void setHealthPoints(HealthPoint healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setExperiencePoints(ExperiencePoint experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public void setLevel(Level level) {
        this.level = level;
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
        return Objects.hash(id, parentHeroId, name, healthPoints, experiencePoints, power, armour, specialty, rarity, level, userId);
    }
}
