package com.cleancodeheroes.adapter.in;

import com.cleancodeheroes.hero.adapter.in.CreateHeroRequest;
import com.cleancodeheroes.hero.adapter.in.HeroController;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.services.CreateHeroService;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.BusFactory;
import com.cleancodeheroes.kernel.DefaultCommandBus;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.utils.IdUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroControllerTest {

    @InjectMocks
    private HeroController heroController;

    @Mock
    private CreateHeroService createHeroUseCase;
    private CommandBus commandBus = BusFactory.defaultCommandBus();

    @BeforeEach
    public void initCommandBus(){
        commandBus.register(CreateHeroCommand.class, createHeroUseCase);
    }

    @Test
    public void shouldCreateHero(){
        CreateHeroRequest createHeroRequest = new CreateHeroRequest();
        createHeroRequest.name = "nathan";
        createHeroRequest.specialty = "Assassin";
        createHeroRequest.rarity = "Common";
        
        CreateHeroCommand createHeroCommand = new CreateHeroCommand(
                createHeroRequest.name,
                createHeroRequest.healthPoints,
                createHeroRequest.experiencePoints,
                createHeroRequest.power,
                createHeroRequest.armour,
                createHeroRequest.specialty,
                createHeroRequest.rarity,
                createHeroRequest.level
        );
        
        when(commandBus.post(createHeroCommand)).thenReturn(HeroId.of(IdUtils.newUUID()));
        heroController.create(createHeroRequest);

    }
}
