package com.cleancodeheroes.hero.application.services;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.in.FindHeroesByRarityQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroesByRarityUseCase;
import com.cleancodeheroes.hero.application.port.out.FindHeroesByRarityPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.shared.domain.Rarity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public final class FinderHeroesByRarityService implements FindHeroesByRarityUseCase {
    private final FindHeroesByRarityPort findHeroesByRarityPort;

    public FinderHeroesByRarityService(FindHeroesByRarityPort findHeroesByRarityPort) {
        this.findHeroesByRarityPort = findHeroesByRarityPort;
    }

    @Override
    public ArrayList<Hero> handle(FindHeroesByRarityQuery query) throws HeroNotFoundException {
        return this.findHeroesByRarityPort.loadAllByRarity(new Rarity(query.rarity));
    }
}
