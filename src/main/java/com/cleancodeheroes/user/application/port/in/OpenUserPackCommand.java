package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.Command;

import java.util.ArrayList;

public class OpenUserPackCommand implements Command {
   public final ArrayList<Hero> heroes;

    public OpenUserPackCommand(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }
}
