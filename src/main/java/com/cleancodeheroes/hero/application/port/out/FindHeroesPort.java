package com.cleancodeheroes.hero.application.port.out;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.domain.Hero;

import java.util.ArrayList;

public interface FindHeroesPort {
    ArrayList<Hero> loadAll() throws HeroNotFoundException;
}
