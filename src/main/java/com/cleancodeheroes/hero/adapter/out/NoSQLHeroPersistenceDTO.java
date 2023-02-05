package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.domain.HeroProps;

public class NoSQLHeroPersistenceDTO {
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer power ;
    private final Integer armour ;
    private final String specialty;
    private final String rarity ;


    public NoSQLHeroPersistenceDTO(HeroProps heroProps) {
        this.name = heroProps.getName();
        this.healthPoints = heroProps.getHealthPoints();
        this.power = heroProps.getPower();
        this.armour = heroProps.getArmour();
        this.specialty = heroProps.getSpecialty().toString();
        this.rarity = heroProps.getRarity().toString();
    }

    public String getName() {
        return name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
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
}
