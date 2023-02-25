package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.kernel.command.Command;

import java.util.Objects;

public final class CreateHeroCommand implements Command {

    private final String name ;
    private final String specialty;
    private final String rarity ;


    public CreateHeroCommand(
            String name,
            String specialty,
            String rarity
    ) {
        this.name = name;
        this.specialty = specialty;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
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
        return getName().equals(that.getName()) && getSpecialty().equals(that.getSpecialty()) && getRarity().equals(that.getRarity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSpecialty(), getRarity());
    }

}
