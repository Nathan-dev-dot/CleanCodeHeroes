package com.cleancodeheroes.application.service;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.services.CreateHeroService;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.utils.IdUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateHeroServiceTest {
    @InjectMocks
    private CreateHeroService service;
    @Mock
    private NoSQLHeroPersistence database;
    private Hero hero;
    private CreateHeroCommand createHeroCommand;

    @BeforeEach
    public void setUpHeroAndHeroCommand(){
        this.hero = new HeroBuilder()
                .id("636a251153fb870ab055eca6")
                .specialty("Tank")
                .basicStats()
                .rarity("Rare")
                .name("nathan")
                .build();
    }

    @Test
    public void shouldReturnHeroId(){
        this.createHeroCommand = new CreateHeroCommand(
                hero.Name(),
                hero.HealthPoints(),
                hero.ExperiencePoints(),
                hero.Power(),
                hero.Armour(),
                hero.Specialty().value().name(),
                hero.Rarity().value().toString(),
                hero.Level()
        );

        final var heroId = HeroId.of("636a251153fb870ab055eca6");
        when(database.save(this.hero)).thenReturn(heroId);
        final var actual = this.service.handle(createHeroCommand);
        Assertions.assertEquals(this.hero.Id().value(), actual.value());
    }
}
