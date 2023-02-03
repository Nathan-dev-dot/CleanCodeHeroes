package com.cleancodeheroes.application.service;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.services.FindHeroService;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindHeroServiceTest {

    @InjectMocks
    private FindHeroService service;
    @Mock
    private NoSQLHeroPersistence database;

    private FindHeroQuery findHeroQuery;

    @Test
    public void ShouldFindHeroInDatabase(){
        HeroId heroId = HeroId.of(new ObjectId("636a251153fb870ab055eca6"));

        Hero hero = new HeroBuilder()
                .id("636a251153fb870ab055eca6")
                .specialty("Tank")
                .basicStats()
                .rarity("Rare")
                .name("nathan")
                .build();
        when(database.load(heroId)).thenReturn(hero);

        this.findHeroQuery = new FindHeroQuery("636a251153fb870ab055eca6");

        final var heroFind = this.service.handle(this.findHeroQuery);
        Assertions.assertEquals(hero.Id().value(), heroFind.Id().value());
    }
}
