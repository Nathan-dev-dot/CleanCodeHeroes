package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.BusFactory;
import com.cleancodeheroes.kernel.command.CommandBus;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroControllerTest {

    @InjectMocks
    private HeroController heroController;

    @Mock
    private CreationHeroService createHeroUseCase;
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
                createHeroRequest.power,
                createHeroRequest.armour,
                createHeroRequest.specialty,
                createHeroRequest.rarity
        );
        
        when(commandBus.post(createHeroCommand)).thenReturn(HeroId.of(new ObjectId()));
        heroController.create(createHeroRequest);

    }
}
