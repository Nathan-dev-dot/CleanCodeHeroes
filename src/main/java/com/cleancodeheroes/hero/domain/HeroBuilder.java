package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.card.domain.Armour;
import com.cleancodeheroes.card.domain.HealthPoint;
import com.cleancodeheroes.card.domain.Power;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;
import com.cleancodeheroes.shared.domain.SpecialtyCharacteristics;
import com.cleancodeheroes.utils.CharacteristicUtils;

import java.util.MissingResourceException;

public final class HeroBuilder {
    private HeroId id = null ;
    private String name ;
    private HealthPoint healthPoints   ;
    private Power power ;
    private Specialty specialty;
    private Armour armour ;
    private Rarity rarity ;
    private SpecialtyCharacteristics baseCharacteristics;

    public Hero build () {
        var heroProps = new HeroProps(
                this.id,
                this.name,
                this.healthPoints.value(),
                this.power.value(),
                this.armour.value(),
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
        this.id = new HeroId();
        return this;
    }

    public HeroBuilder name (String name) throws IllegalArgumentException {
        if (name == null || name.equals("")) throw new IllegalArgumentException();
        this.name = name;
        return this;
    }

    public HeroBuilder specialty (String specialty) throws IllegalArgumentException {
        this.specialty = Specialty.of(specialty) ;
        this.baseCharacteristics = SpecialtyCharacteristics.of(this.specialty.value());
        return this;
    }

    public HeroBuilder basicStats () throws MissingResourceException {
        if (this.baseCharacteristics == null) {
            throw new MissingResourceException("Missing ressource", "HeroBuilder", "baseCharacteristics");
        }
        if (this.rarity == null) {
            throw new MissingResourceException("Missing resource", "HeroBuilder", "rarity");
        }
        this.armour();
        this.power();
        this.healthPoints();
        return this;
    }

    private void healthPoints() throws IllegalArgumentException {
        this.healthPoints = HealthPoint.of(
                CharacteristicUtils.increaseByFactor(
                        this.baseCharacteristics.getBaseHealthPoints(),
                        this.rarity.baseIncreaseFactor()
                )
        );
    }

    private void power () throws IllegalArgumentException {
        this.power = Power.of(
                CharacteristicUtils.increaseByFactor(
                        this.baseCharacteristics.getBasePower(),
                        this.rarity.baseIncreaseFactor()
                )
        );
    }

    private void armour() throws IllegalArgumentException {
        this.armour = Armour.of(
                CharacteristicUtils.increaseByFactor(
                        this.baseCharacteristics.getBaseArmour(),
                        this.rarity.baseIncreaseFactor()
                )
        );
    }

    public HeroBuilder rarity (String rarity) throws IllegalArgumentException {
        this.rarity = new Rarity(rarity);
        return this;
    }
}
