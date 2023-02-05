package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.shared.domain.Rarity;

public class HeroProps {
    private final HeroId id ;
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;

    public HeroProps(
            HeroId id,
            String name,
            Integer healthPoints ,
            Integer power,
            Integer armour,
            Specialty specialty,
            Rarity rarity
    ) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.power = power;
        this.armour = armour;
        this.specialty = specialty;
        this.rarity = rarity;
    }

    public HeroId getId() {
        return id;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public Rarity getRarity() {
        return rarity;
    }

}
