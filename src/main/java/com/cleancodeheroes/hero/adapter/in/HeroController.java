package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hero")
public class HeroController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private HeroController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody @Valid CreateHeroRequest createAccountRequest) {
        CreateHeroCommand createHeroCommand = new CreateHeroCommand(
                createAccountRequest.name,
                createAccountRequest.healthPoints,
                createAccountRequest.experiencePoints,
                createAccountRequest.power,
                createAccountRequest.armour,
                createAccountRequest.specialty,
                createAccountRequest.rarity,
                createAccountRequest.level
        );
        var heroId = (HeroId) commandBus.post(createHeroCommand);
        return heroId.value().toString();
    }

    @GetMapping
    public GetHeroResponse getHero(@RequestParam String heroId){
        try{
            var hero = (Hero) queryBus.post(new FindHeroQuery(heroId));
            return ResponseEntity
                    .ok()
                    .body(new GetHeroResponse(hero))
                    .getBody();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

    }
}
