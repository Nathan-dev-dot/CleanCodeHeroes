package com.cleancodeheroes.hero.application.services;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroesUseCase;
import com.cleancodeheroes.hero.application.port.out.FindHeroesPort;
import com.cleancodeheroes.hero.domain.Hero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public final class FinderHeroesService implements FindHeroesUseCase {
    private final FindHeroesPort findHeroesPort;

    public FinderHeroesService(FindHeroesPort findHeroesPort) {
        this.findHeroesPort = findHeroesPort;
    }

    @Override
    public ArrayList<Hero> handle(FindHeroesQuery query) throws HeroNotFoundException {
        return this.findHeroesPort.loadAll();
    }
}
