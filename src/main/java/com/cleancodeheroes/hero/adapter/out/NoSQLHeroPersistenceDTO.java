package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.domain.Hero;

public final class NoSQLHeroPersistenceDTO {
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer power ;
    private final Integer armour ;
    private final String specialty;
    private final String rarity ;


    public NoSQLHeroPersistenceDTO(Hero heroProps) {
        this.name = heroProps.Name();
        this.healthPoints = heroProps.HealthPoints();
        this.power = heroProps.Power();
        this.armour = heroProps.Armour();
        this.specialty = heroProps.Specialty().toString();
        this.rarity = heroProps.Rarity().toString();
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
