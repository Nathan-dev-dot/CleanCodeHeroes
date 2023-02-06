package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.domain.Card;

public final class NoSQLCardPersistenceDTO {
    public final String name;
    public final Integer healthPoints ;
    public final Integer experiencePoints ;
    public final Integer power ;
    public final Integer armour ;
    public final String specialty;
    public final String rarity ;
    public final Integer level ;

    public NoSQLCardPersistenceDTO (Card cardProps) {
        this.name = cardProps.Name();
        this.healthPoints = cardProps.HealthPoints();
        this.experiencePoints = cardProps.ExperiencePoints();
        this.power = cardProps.Power();
        this.armour = cardProps.Armour();
        this.specialty = cardProps.Specialty().toString();
        this.rarity = cardProps.Rarity().toString();
        this.level = cardProps.Level();
    }
}
