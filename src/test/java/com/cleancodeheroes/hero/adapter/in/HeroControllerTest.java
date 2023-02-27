package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@RunWith(SpringRunner.class)
//@WebMvcTest(HeroController.class)
@ExtendWith(MockitoExtension.class)
public final class HeroControllerTest {

    @InjectMocks
    private HeroController heroController;

    @Mock
    private CreationHeroService createHeroUseCase;
    @Mock
    private CommandBus commandBus;

    @Mock
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void shouldCreateHero(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(heroController).build();

        CreateHeroRequest createHeroRequest = new CreateHeroRequest();
        createHeroRequest.name = "TestHero";
        createHeroRequest.specialty = "Assassin";
        createHeroRequest.rarity = "Common";

        ObjectId createdId = new ObjectId();

        try {
            when(commandBus.post(any(CreateHeroCommand.class))).thenReturn(HeroId.of(createdId));
            MvcResult result = this.mockMvc.perform(
                    post("/api/hero")
                            .content(objectMapper.writeValueAsString(createHeroRequest))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
            ).andReturn();
            var content = result.getResponse();
            System.out.println(content.getContentAsString());
            Assertions.assertEquals(createdId.toString(), result.getResponse().getContentAsString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
