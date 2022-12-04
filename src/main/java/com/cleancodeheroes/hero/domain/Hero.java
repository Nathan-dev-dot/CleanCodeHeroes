package com.cleancodeheroes.hero.domain;

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
