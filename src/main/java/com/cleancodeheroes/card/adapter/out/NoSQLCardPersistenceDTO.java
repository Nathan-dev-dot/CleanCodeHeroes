package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.domain.Card;

public class NoSQLCardPersistenceDTO {
    private final String name;
    private final Integer healthPoints ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final String specialty;
    private final String rarity ;
    private final Integer level ;

    public NoSQLCardPersistenceDTO (Card cardProps) {
        this.name = cardProps.Name();
        this.healthPoints = cardProps.HealthPoints();
        this.experiencePoints = cardProps.ExperiencePoints();
        this.power = cardProps.Power();
        this.armour = cardProps.Armour();
        this.specialty = cardProps.Specialty().toString();
        this.rarity = cardProps.Rarity().toString();
        this.level = cardProps.Level();
    }

    public String getName() {
        return name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getArmour() {
        return armour;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getRarity() {
        return rarity;
    }

    public Integer getLevel() {
        return level;
    }
}
