package com.cleancodeheroes.hero.application.port.out;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;

public interface CreateHeroPort {
    HeroId save(Hero hero) throws IllegalArgumentException;
}
