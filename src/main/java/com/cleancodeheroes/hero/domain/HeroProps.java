package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.shared.domain.Rarity;

public final class HeroProps {
    public final HeroId id ;
    public final String name ;
    public final Integer healthPoints  ;
    public final Integer power ;
    public final Integer armour ;
    public final Specialty specialty;
    public final Rarity rarity ;

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

    public static HeroProps of(Hero hero) {
        return new HeroProps(
            hero.Id(),
            hero.Name(),
            hero.HealthPoints(),
            hero.Power(),
            hero.Armour(),
            hero.Specialty(),
            hero.Rarity()
        );
    }
}
