package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.Command;
import com.cleancodeheroes.user.domain.PackType;

import java.util.ArrayList;

public class OpenUserPackCommand implements Command {
   public final ArrayList<Hero> heroes;

   public final PackType packType;

    public OpenUserPackCommand(PackType packType, ArrayList<Hero> heroes) {
        this.packType = packType;
        this.heroes = heroes;
    }
}
