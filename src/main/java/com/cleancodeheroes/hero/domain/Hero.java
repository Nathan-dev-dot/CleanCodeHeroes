package com.cleancodeheroes.hero.domain;

import java.util.Objects;

public class Hero {
    private final HeroId id ;
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer experiencePoints ;
    private final Integer power ;

    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;
    private final Integer level ;

    public Hero (HeroProps heroProps) {

        this.id = heroProps.getId();
        this.name = heroProps.getName();
        this.healthPoints = heroProps.getHealthPoints();
        this.experiencePoints = heroProps.getExperiencePoints();
        this.power = heroProps.getPower();
        this.armour = heroProps.getArmour();
        this.specialty = heroProps.getSpecialty();
        this.rarity = heroProps.getRarity();
        this.level = heroProps.getLevel();
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
        if (!(o instanceof Hero hero)) {
            return false;
        };
        return id.equals(hero.id);
        //&& name.equals(hero.name) && healthPoints.equals(hero.healthPoints) && experiencePoints.equals(hero.experiencePoints) && power.equals(hero.power) && armour.equals(hero.armour) && specialty.equals(hero.specialty) && rarity.equals(hero.rarity) && level.equals(hero.level);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, healthPoints, experiencePoints, power, armour, specialty, rarity, level);
    }
}
