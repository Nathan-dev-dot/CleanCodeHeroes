package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;

import java.util.Objects;

public final class CardProps {
    public final CardId id;
    public final HeroId parentHeroId;
    public final String name;
    public final HealthPoint healthPoints ;
    public final ExperiencePoint experiencePoints ;
    public final Power power ;
    public final Armour armour ;
    public final Specialty specialty;
    public final Rarity rarity ;
    public final Level level ;

    public CardProps(
            String cardId,
            String parentHeroId,
            String name,
            Integer healthPoints,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            String specialty,
            String rarity,
            Integer level) throws IllegalArgumentException {
        this.id = CardId.of(cardId);
        this.parentHeroId = HeroId.of(parentHeroId);
        this.name = name;
        this.healthPoints = HealthPoint.of(healthPoints);
        this.experiencePoints = ExperiencePoint.of(experiencePoints);
        this.power = Power.of(power);
        this.armour = Armour.of(armour);
        this.specialty = Specialty.of(specialty);
        this.rarity = new Rarity(rarity);
        this.level = Level.of(level);
    }

    public static CardProps of(Card card) throws IllegalArgumentException {
        return new CardProps (
                card.getId().value(),
                card.getParentHeroId().value(),
                card.getName(),
                card.getHealthPoints().getHealthPoint(),
                card.getExperiencePoints().getExperiencePoint(),
                card.getPower().getPower(),
                card.getArmour().getArmour(),
                card.getSpecialty().toString(),
                card.getRarity().toString(),
                card.getLevel().getLevel()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardProps cardProps = (CardProps) o;
        return Objects.equals(id, cardProps.id) && Objects.equals(parentHeroId, cardProps.parentHeroId) && Objects.equals(name, cardProps.name) && Objects.equals(healthPoints, cardProps.healthPoints) && Objects.equals(experiencePoints, cardProps.experiencePoints) && Objects.equals(power, cardProps.power) && Objects.equals(armour, cardProps.armour) && Objects.equals(specialty, cardProps.specialty) && Objects.equals(rarity, cardProps.rarity) && Objects.equals(level, cardProps.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentHeroId, name, healthPoints, experiencePoints, power, armour, specialty, rarity, level);
    }
}
