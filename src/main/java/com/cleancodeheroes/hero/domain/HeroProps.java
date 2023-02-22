package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.card.domain.Armour;
import com.cleancodeheroes.card.domain.HealthPoint;
import com.cleancodeheroes.card.domain.Power;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;

public final class HeroProps {
    public final HeroId id ;
    public final String name ;
    public final HealthPoint healthPoints  ;
    public final Power power ;
    public final Armour armour ;
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
    ) throws IllegalArgumentException {
        this.id = id;
        this.name = name;
        this.healthPoints = HealthPoint.of(healthPoints);
        this.power = Power.of(power);
        this.armour = Armour.of(armour);
        this.specialty = specialty;
        this.rarity = rarity;
    }

    public static HeroProps of(Hero hero) {
        return new HeroProps(
            hero.Id(),
            hero.Name(),
            hero.HealthPoints().value(),
            hero.Power().value(),
            hero.Armour().value(),
            hero.Specialty(),
            hero.Rarity()
        );
    }
}
