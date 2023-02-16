package com.cleancodeheroes.card.domain;

import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;

public final class CardProps {
    public final CardId id;
    public final String name;
    public final Integer healthPoints ;
    public final ExperiencePoint experiencePoints ;
    public final Power power ;
    public final Armour armour ;
    public final Specialty specialty;
    public final Rarity rarity ;
    public final Level level ;

    public CardProps(
            CardId id,
            String name,
            Integer healthPoints,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            Specialty specialty,
            Rarity rarity,
            Integer level) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = new ExperiencePoint(experiencePoints);
        this.power = new Power(power);
        this.armour = new Armour(armour);
        this.specialty = specialty;
        this.rarity = rarity;
        this.level = new Level(level);
    }

    public static CardProps of(Card card) {
        return new CardProps (
                card.getId(),
                card.getName(),
                card.getHealthPoints(),
                card.getExperiencePoints().getExperiencePoint(),
                card.getPower().getPower(),
                card.getArmour().getArmour(),
                card.getSpecialty(),
                card.getRarity(),
                card.getLevel().getLevel()
        );
    }
}
