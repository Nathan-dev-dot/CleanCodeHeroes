package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.domain.Hero;

public final class NoSQLHeroPersistenceDTO {
    public final String name ;
    public final Integer healthPoints  ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;


    public NoSQLHeroPersistenceDTO(Hero hero) {
        this.name = hero.Name();
        this.healthPoints = hero.HealthPoints();
        this.power = hero.Power();
        this.armour = hero.Armour();
        this.specialty = hero.Specialty().toString();
        this.rarity = hero.Rarity().toString();
    }
}
