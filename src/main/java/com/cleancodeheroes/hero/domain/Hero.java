package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.card.domain.Armour;
import com.cleancodeheroes.card.domain.HealthPoint;
import com.cleancodeheroes.card.domain.Power;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;

import java.util.Objects;

public final class Hero {
    private final HeroId id ;
    private final String name ;
    private final HealthPoint healthPoints  ;
    private final Power power ;
    private final Armour armour ;
    private final Specialty specialty;
    private final Rarity rarity ;

    public Hero (HeroProps heroProps) {
        this.id = heroProps.id;
        this.name = heroProps.name;
        this.healthPoints = heroProps.healthPoints;
        this.power = heroProps.power;
        this.armour = heroProps.armour;
        this.specialty = heroProps.specialty;
        this.rarity = heroProps.rarity;
    }

    public HeroId Id() {
        return id;
    }

    public String Name() {
        return name;
    }

    public HealthPoint HealthPoints() {
        return healthPoints;
    }

    public Power Power() {
        return power;
    }

    public Armour Armour() {
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
        if (!(o instanceof Hero hero)) return false;
        return Objects.equals(id, hero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
