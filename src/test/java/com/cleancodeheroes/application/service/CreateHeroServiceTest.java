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
                .id("717c4b00-b8ef-4a6d-a0ab-d4ac6df9d197")
                .specialty("Tank")
                .basicStats()
                .rarity("Rare")
                .name("nathan")
                .build();
        
        this.createHeroCommand = new CreateHeroCommand(
                hero.Name(),
                hero.HealthPoints(),
                hero.ExperiencePoints(),
                hero.Power(),
                hero.Armour(),
                hero.Specialty().value().name(),
                hero.Rarity().value().toString(),
                hero.Level());
    }

    @Test
    public void shouldReturnHeroId(){
        UUID uuid = UUID.fromString("717c4b00-b8ef-4a6d-a0ab-d4ac6df9d197");

        try (MockedStatic<IdUtils> idUtilsMock = Mockito.mockStatic(IdUtils.class)) {
//            when(IdUtils.newUUID()).thenReturn(uuid);
            when(database.save(hero)).thenReturn(HeroId.of("717c4b00-b8ef-4a6d-a0ab-d4ac6df9d197"));
            final var actual = service.handle(createHeroCommand);
            Assertions.assertEquals(hero.Id().value(), actual.value());
        }
    }
}
