package com.cleancodeheroes.hero.application.port.out;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;

import java.util.Optional;

public interface FindHeroPort {
    Optional<Hero> load (HeroId heroId) throws HeroNotFoundException;
}
