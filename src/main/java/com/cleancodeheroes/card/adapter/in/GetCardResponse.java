package com.cleancodeheroes.card.adapter.in;

import com.cleancodeheroes.card.domain.Card;

public class GetCardResponse {
    public final String id;
    public final String name;
    public final Integer healthPoints ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;
    public final Integer level ;

    public GetCardResponse(Card card) {
        this.id = card.Id().value();
        this.name = card.Name();
        this.healthPoints = card.HealthPoints();
        this.experiencePoints = card.ExperiencePoints();
        this.power = card.Power();
        this.armour = card.Armour();
        this.specialty = card.Specialty().toString();
        this.rarity = card.Rarity().toString();
        this.level = card.Level();
    }

}
