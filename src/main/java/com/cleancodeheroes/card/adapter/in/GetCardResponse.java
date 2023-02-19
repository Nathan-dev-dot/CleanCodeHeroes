package com.cleancodeheroes.card.adapter.in;

import com.cleancodeheroes.card.domain.Card;

public class GetCardResponse {
    public final String id;
    public final String parentHeroId;
    public final String name;
    public final Integer healthPoints ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;
    public final Integer level ;
    public final String userId;

    public GetCardResponse(Card card) {
        this.id = card.getId().value();
        this.parentHeroId = card.getParentHeroId().value();
        this.name = card.getName();
        this.healthPoints = card.getHealthPoints().getHealthPoint();
        this.experiencePoints = card.getExperiencePoints().getExperiencePoint();
        this.power = card.getPower().getPower();
        this.armour = card.getArmour().getArmour();
        this.specialty = card.getSpecialty().toString();
        this.rarity = card.getRarity().toString();
        this.level = card.getLevel().getLevel();
        this.userId = card.getUserId().value();
    }
}
