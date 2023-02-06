package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.shared.domain.Rarity;
import org.bson.types.ObjectId;

import java.util.MissingResourceException;

public final class HeroBuilder {
    private HeroId id = null ;
    private String name ;
    private Integer healthPoints  ;
    private Integer power ;
    private Specialty specialty;
    private Integer armour ;
    private Rarity rarity ;
    private SpecialtyCharacteristics baseCharacteristics;

    public Hero build () {
        var heroProps = new HeroProps(
                this.id,
                this.name,
                this.healthPoints,
                this.power,
                this.armour,
                this.specialty,
                this.rarity
        );
        return new Hero(heroProps);
    }

    public HeroBuilder id (String id) throws IllegalArgumentException {
        this.id = HeroId.of(id);
        return this;
    }

    public HeroBuilder id () {
        this.id = HeroId.of(new ObjectId());
        return this;
    }

    public HeroBuilder name (String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) throw new IllegalArgumentException();
        this.name = name;
        return this;
    }

    public HeroBuilder specialty (String specialty) throws IllegalArgumentException {
        this.specialty = Specialty.of(specialty) ;
        switch (this.specialty.value()) {
            case Tank -> {
                this.baseCharacteristics = SpecialtyCharacteristics.Tank();
            }
            case Assassin -> {
                this.baseCharacteristics = SpecialtyCharacteristics.Assasin();
            }
            case Sorcerer -> {
                this.baseCharacteristics = SpecialtyCharacteristics.Sorcerer();
            }
        }
        return this;
    }

    public HeroBuilder basicStats () throws MissingResourceException {
        if (this.baseCharacteristics == null) {
            throw new MissingResourceException("Missing ressource", "HeroBuilder", "baseCharacteristics");
        }
        this.armour = this.baseCharacteristics.getBaseArmour();
        this.power = this.baseCharacteristics.getBasePower();
        this.healthPoints = this.baseCharacteristics.getBaseHealthPoints();
        return this;
    }

    public HeroBuilder healthPoints(Integer healthPoints) throws IllegalArgumentException {
        if (healthPoints < 0) throw new IllegalArgumentException();
        this.healthPoints = healthPoints;
        return this;
    }

    public HeroBuilder power(Integer power) throws IllegalArgumentException {
        if (power < 0) throw new IllegalArgumentException();
        this.power = power;
        return this;
    }

    public HeroBuilder armour(Integer armour) throws IllegalArgumentException {
        if (armour < 0) throw new IllegalArgumentException();
        this.armour = armour;
        return this;
    }

    public HeroBuilder rarity (String rarity) throws IllegalArgumentException {
        this.rarity = new Rarity(rarity);
        return this;
    }
}
