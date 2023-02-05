package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.shared.domain.Rarity;

import java.util.Objects;

public class Hero {
    private final HeroId id ;
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;

    private Hero (HeroProps heroProps) {

        this.id = heroProps.getId();
        this.name = heroProps.getName();
        this.healthPoints = heroProps.getHealthPoints();
        this.power = heroProps.getPower();
        this.armour = heroProps.getArmour();
        this.specialty = heroProps.getSpecialty();
        this.rarity = heroProps.getRarity();
    }

    public static Hero create (HeroProps heroProps) {
        return new Hero(heroProps);
    }

    public HeroId Id() {
        return id;
    }

    public String Name() {
        return name;
    }

    public Integer HealthPoints() {
        return healthPoints;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) {
            return false;
        };
        return id.equals(hero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, healthPoints, power, armour, specialty, rarity);
    }

}
