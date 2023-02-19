package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

public final class CardProps {
    public final CardId id;
    public final HeroId baseHeroId;
    public final String name;
    public final Integer healthPoints ;
    public final ExperiencePoint experiencePoints ;
    public final Power power ;
    public final Armour armour ;
    public final Specialty specialty;
    public final Rarity rarity ;
    public final Level level ;

    public CardProps(
            String cardId,
            String baseHeroId,
            String name,
            Integer healthPoints,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            String specialty,
            String rarity,
            Integer level) throws IllegalArgumentException {
        this.id = CardId.of(cardId);
        this.baseHeroId = HeroId.of(baseHeroId);
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = ExperiencePoint.of(experiencePoints);
        this.power = Power.of(power);
        this.armour = Armour.of(armour);
        this.specialty = Specialty.of(specialty);
        this.rarity = new Rarity(rarity);
        this.level = Level.of(level);
    }

    public static CardProps of(Card card) {
        return new CardProps (
                card.getId().value(),
                card.getBaseHeroId().value(),
                card.getName(),
                card.getHealthPoints(),
                card.getExperiencePoints().getExperiencePoint(),
                card.getPower().getPower(),
                card.getArmour().getArmour(),
                card.getSpecialty().toString(),
                card.getRarity().toString(),
                card.getLevel().getLevel()
        );
    }
}
