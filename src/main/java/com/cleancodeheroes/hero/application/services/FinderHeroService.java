package com.cleancodeheroes.hero.application.services;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroUseCase;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;

public final class FinderHeroService implements FindHeroUseCase {
    private final FindHeroPort findHeroPort;

    public FinderHeroService(FindHeroPort findHeroPort) {
        this.findHeroPort = findHeroPort;
    }

    @Override
    public Hero handle(FindHeroQuery query) throws HeroNotFoundException {
        return this.findHeroPort.load(HeroId.of(query.heroId));
    }
}
