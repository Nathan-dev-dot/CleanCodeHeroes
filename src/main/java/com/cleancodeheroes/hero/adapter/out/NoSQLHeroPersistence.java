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
        registry.put(HeroId.of(IdUtils.UUIDFromString("717c4b00-b8ef-4a6d-a0ab-d4ac6df9d197")),
                new HeroBuilder()
                        .id("717c4b00-b8ef-4a6d-a0ab-d4ac6df9d197")
                        .specialty("Tank")
                        .basicStats()
                        .rarity("Rare")
                        .name("nathan")
                        .build()
        );
        return registry.computeIfAbsent(heroId,
                key -> {
                    throw HeroException.notFoundHeroId(heroId);
                });
    }
}
