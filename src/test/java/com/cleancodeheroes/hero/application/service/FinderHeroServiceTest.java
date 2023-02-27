package com.cleancodeheroes.hero.application.service;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public final class FinderHeroServiceTest {

    @InjectMocks
    private FinderHeroService service;
    @Mock
    private FindHeroPort findHeroPort;

    @Mock
    private FindHeroQuery findHeroQuery;

    @Test
    public void ShouldFindHeroInDatabase(){

        Hero hero = new HeroBuilder()
                .id("636a251153fb870ab055eca6")
                .specialty("Tank")
                .rarity("Rare")
                .basicStats()
                .name("nathan")
                .build();
        try {
            when(findHeroPort.load(any(HeroId.class))).thenReturn(hero);
            this.findHeroQuery = new FindHeroQuery("636a251153fb870ab055eca6");
            final var heroFind = this.service.handle(this.findHeroQuery);
            Assertions.assertEquals(hero.Id().value(), heroFind.Id().value());
        } catch (HeroNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void ShouldThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.service.handle(findHeroQuery);
        });
    }

    @Test
    public void ShouldThrowHeroNotFoundException(){
        try {
            when(findHeroPort.load(any(HeroId.class))).thenThrow(new HeroNotFoundException());
            this.findHeroQuery = new FindHeroQuery("636a251153fb870ab055eca6");
            Assertions.assertThrows(HeroNotFoundException.class, () -> {
                this.service.handle(findHeroQuery);
            });
        } catch (HeroNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
