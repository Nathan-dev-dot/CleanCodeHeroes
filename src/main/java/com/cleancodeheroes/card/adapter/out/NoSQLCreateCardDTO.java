package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.domain.Card;

public final class NoSQLCreateCardDTO {
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

    public NoSQLCreateCardDTO(Card cardProps) {
        this.parentHeroId = cardProps.getParentHeroId().value();
        this.name = cardProps.getName();
        this.healthPoints = cardProps.getHealthPoints().value();
        this.experiencePoints = cardProps.getExperiencePoints().getExperiencePoint();
        this.power = cardProps.getPower().value();
        this.armour = cardProps.getArmour().value();
        this.specialty = cardProps.getSpecialty().toString();
        this.rarity = cardProps.getRarity().toString();
        this.level = cardProps.getLevel().value();
        this.userId = cardProps.getUserId().value();
    }
}
