package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.kernel.command.Command;

import java.util.Objects;

public class CreateHeroCommand implements Command {

    private final String name ;
    private final Integer healthPoints  ;
    private final Integer power ;
    private final Integer armour ;
    private final String specialty;
    private final String rarity ;


    public CreateHeroCommand(
            String name,
            Integer healthPoints,
            Integer power,
            Integer armour,
            String specialty,
            String rarity
    ) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.power = power;
        this.armour = armour;
        this.specialty = specialty;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getArmour() {
        return armour;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getRarity() {
        return rarity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateHeroCommand that)) return false;
        return getName().equals(that.getName()) && getHealthPoints().equals(that.getHealthPoints()) && getPower().equals(that.getPower()) && getArmour().equals(that.getArmour()) && getSpecialty().equals(that.getSpecialty()) && getRarity().equals(that.getRarity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealthPoints(), getPower(), getArmour(), getSpecialty(), getRarity());
    }

}
