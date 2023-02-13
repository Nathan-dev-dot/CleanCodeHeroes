package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.services.CreationHeroService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@RunWith(SpringRunner.class)
//@WebMvcTest(HeroController.class)
@ExtendWith(MockitoExtension.class)
public final class HeroControllerTest {

    @InjectMocks
    private HeroController heroController;

    @Mock
    private CreationHeroService createHeroUseCase;
//    @Mock
//    private CommandBus commandBus = BusFactory.defaultCommandBus();
    @Autowired
    private MockMvc mockMvc;

//    @BeforeEach
//    public void initCommandBus(){
//        commandBus.register(CreateHeroCommand.class, createHeroUseCase);
//    }

    @Test
    public void shouldCreateHero(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(heroController).build();

        CreateHeroRequest createHeroRequest = new CreateHeroRequest();
        createHeroRequest.name = "TestHero";
        createHeroRequest.specialty = "Assassin";
        createHeroRequest.rarity = "Common";
        
//        CreateHeroCommand createAssassinCommand = new CreateHeroCommand(
//                createHeroRequest.name,
//                createHeroRequest.specialty,
//                createHeroRequest.rarity
//        );

        ObjectId createdId = new ObjectId();
//        when((HeroId)  commandBus.post(createAssassinCommand)).thenReturn(HeroId.of(createdId));
        try {
            MvcResult result = this.mockMvc.perform(
                    post("/api/hero")
                            .param("name", createHeroRequest.name)
                            .param("specialty", createHeroRequest.specialty)
                            .param("rarity", createHeroRequest.rarity)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
            ).andReturn();
            var content = result.getResponse();
            System.out.println(content);
            Assertions.assertEquals(createdId.toString(), result.getResponse().getContentAsString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
