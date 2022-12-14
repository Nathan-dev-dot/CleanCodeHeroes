package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.domain.Hero;

public class GetHeroResponse {
    public final String name;
    public final String id ;
    public final Integer healthPoints  ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;
    public final Integer level ;


    public GetHeroResponse(Hero hero) {
        this.name = hero.Name();
        this.id = hero.Id().value().toString();
        this.healthPoints = hero.HealthPoints();
        this.experiencePoints = hero.ExperiencePoints();
        this.power = hero.Power();
        this.armour = hero.Armour();
        this.specialty = hero.Specialty().toString();
        this.rarity = hero.Rarity().toString();
        this.level = hero.Level();
    }
}
