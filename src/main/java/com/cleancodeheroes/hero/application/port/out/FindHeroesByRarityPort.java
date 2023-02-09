package com.cleancodeheroes.hero.application.port.out;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.shared.domain.Rarity;

import java.util.ArrayList;

public interface FindHeroesByRarityPort {
    ArrayList<Hero> loadAllByRarity(Rarity rarity) throws HeroNotFoundException;
}
