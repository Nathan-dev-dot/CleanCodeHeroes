package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.domain.Hero;

public final class GetHeroResponse {
    public final String name;
    public final String id ;
    public final Integer healthPoints  ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;


    public GetHeroResponse(Hero hero) {
        this.name = hero.Name();
        this.id = hero.Id().value().toString();
        this.healthPoints = hero.HealthPoints();
        this.power = hero.Power();
        this.armour = hero.Armour();
        this.specialty = hero.Specialty().toString();
        this.rarity = hero.Rarity().toString();
    }
}
