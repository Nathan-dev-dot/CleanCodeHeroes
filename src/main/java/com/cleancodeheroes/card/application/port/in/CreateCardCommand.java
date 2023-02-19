package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.Command;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.Specialty;
import com.cleancodeheroes.user.domain.UserId;

import java.util.Objects;

public final class CreateCardCommand implements Command {
    private final String name;
    private final HeroId parentHeroId;
    private final Integer healthPoints ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final Specialty specialty;
    private final Rarity rarity ;
    private final Integer level ;
    private final UserId userId;

    public CreateCardCommand (Hero hero, UserId userId) {
        this.name = hero.Name();
        this.parentHeroId = hero.Id();
        this.healthPoints = hero.HealthPoints();
        this.experiencePoints = 0;
        this.power = hero.Power();
        this.armour = hero.Armour();
        this.specialty = hero.Specialty();
        this.rarity = hero.Rarity();
        this.userId = userId;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public HeroId getHeroId() {
        return parentHeroId;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getArmour() {
        return armour;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Integer getLevel() {
        return level;
    }

    public UserId getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCardCommand that = (CreateCardCommand) o;
        return Objects.equals(name, that.name) && Objects.equals(parentHeroId, that.parentHeroId) && Objects.equals(healthPoints, that.healthPoints) && Objects.equals(experiencePoints, that.experiencePoints) && Objects.equals(power, that.power) && Objects.equals(armour, that.armour) && Objects.equals(specialty, that.specialty) && Objects.equals(rarity, that.rarity) && Objects.equals(level, that.level) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentHeroId, healthPoints, experiencePoints, power, armour, specialty, rarity, level, userId);
    }
}
