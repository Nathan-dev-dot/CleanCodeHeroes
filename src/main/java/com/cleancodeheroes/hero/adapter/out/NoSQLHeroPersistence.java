package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroException;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.utils.IdUtils;
import lombok.RequiredArgsConstructor;

import javax.naming.NameNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class NoSQLHeroPersistence implements FindHeroPort, CreateHeroPort {
    private final Map<HeroId, Hero> registry = new HashMap<>();
    private static NoSQLHeroPersistence INSTANCE;

    public static synchronized NoSQLHeroPersistence getInstance() {
        if (INSTANCE == null) {
            return new NoSQLHeroPersistence();
        }
        return INSTANCE;
    }
    @Override
    public HeroId save(Hero hero) {
        registry.put(hero.Id(), hero);
        return hero.Id();
    }
    @Override
    public Hero load(HeroId heroId) {
        return registry.computeIfAbsent(heroId,
                key -> {
                    throw HeroException.notFoundHeroId(heroId);
                });
    }
}
