package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.domain.HeroProps;
import com.cleancodeheroes.hero.domain.Rarity;
import com.cleancodeheroes.hero.domain.Specialty;

public class NoSQLHeroPersistenceDTO {
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer experiencePoints ;
    private final Integer power ;

    private final Integer armour ;
    private final String specialty;
    private final String rarity ;
    private final Integer level ;


    public NoSQLHeroPersistenceDTO(HeroProps heroProps) {
        this.name = heroProps.getName();
        this.healthPoints = heroProps.getHealthPoints();
        this.experiencePoints = heroProps.getExperiencePoints();
        this.power = heroProps.getPower();
        this.armour = heroProps.getArmour();
        this.specialty = heroProps.getSpecialty().toString();
        this.rarity = heroProps.getRarity().toString();
        this.level = heroProps.getLevel();
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
