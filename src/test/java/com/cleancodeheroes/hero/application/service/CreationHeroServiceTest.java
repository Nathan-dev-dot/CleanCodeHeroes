package com.cleancodeheroes.hero.application.service;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
public final class CreationHeroServiceTest {
    @InjectMocks
    private CreationHeroService service;
    @Mock
    private CreateHeroPort createHeroPort;
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
                hero.HealthPoints().value(),
                hero.Power().value(),
                hero.Armour().value(),
                hero.Specialty().value().name(),
                hero.Rarity().value().toString()
        );

        final var heroId = HeroId.of("636a251153fb870ab055eca6");
        when(createHeroPort.save(this.hero)).thenReturn(heroId);
        final var actual = this.service.handle(createHeroCommand);
        Assertions.assertEquals(this.hero.Id().value(), actual.value());
    }
}
