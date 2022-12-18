package com.cleancodeheroes.hero.application.port.out;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;

public interface FindHeroPort {
    Hero load(HeroId heroId);
}
