package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.kernel.command.Command;

public class CreateHeroCommand implements Command {

    private final String name ;
    private final Integer healthPoints  ;
    private final Integer experiencePoints ;
    private final Integer power ;
    private final Integer armour ;
    private final String specialty;
    private final String rarity ;
    private final Integer level ;


    public CreateHeroCommand(
            String name,
            Integer healthPoints,
            Integer experiencePoints,
            Integer power,
            Integer armour,
            String specialty,
            String rarity,
            Integer level
    ) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.power = power;
        this.armour = armour;
        this.specialty = specialty;
        this.rarity = rarity;
        this.level = level;
    }

    public String getName() {
        return name;
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

    public String getSpecialty() {
        return specialty;
    }

    public String getRarity() {
        return rarity;
    }

    public Integer getLevel() {
        return level;
    }
}
