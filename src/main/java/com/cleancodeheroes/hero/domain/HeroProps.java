package com.cleancodeheroes.hero.domain;

public class HeroProps {
    private final HeroId id ;
    private final String name ;
    private final Integer healthPoints  ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;
    private final Integer level ;

    public HeroProps(
            HeroId id,
            String name,
            Integer healthPoints ,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            Specialty specialty,
            Rarity rarity,
            Integer level
    ) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.power = power;
        this.armour = armour;
        this.specialty = specialty;
        this.rarity = rarity;
        this.level = level;
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

    public Integer getExperiencePoints() {
        return experiencePoints;
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

    public Integer getLevel() {
        return level;
    }
}
