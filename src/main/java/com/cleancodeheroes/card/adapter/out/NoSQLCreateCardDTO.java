package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.domain.Card;

public final class NoSQLCreateCardDTO {
    public final String heroId;
    public final String name;
    public final Integer healthPoints ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;
    public final Integer level ;

    public NoSQLCreateCardDTO(Card cardProps) {
        this.heroId = cardProps.getBaseHeroId().value();
        this.name = cardProps.getName();
        this.healthPoints = cardProps.getHealthPoints();
        this.experiencePoints = cardProps.getExperiencePoints().getExperiencePoint();
        this.power = cardProps.getPower().getPower();
        this.armour = cardProps.getArmour().getArmour();
        this.specialty = cardProps.getSpecialty().toString();
        this.rarity = cardProps.getRarity().toString();
        this.level = cardProps.getLevel().getLevel();
    }
}
