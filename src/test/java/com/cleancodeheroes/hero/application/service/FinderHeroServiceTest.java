package com.cleancodeheroes.hero.application.service;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FinderHeroServiceTest {

    @InjectMocks
    private FinderHeroService service;
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
//        when(database.load(heroId)).thenReturn(hero);
//
//        this.findHeroQuery = new FindHeroQuery("636a251153fb870ab055eca6");
//
//        final var heroFind = this.service.handle(this.findHeroQuery);
//        Assertions.assertEquals(hero.Id().value(), heroFind.Id().value());
    }
}
