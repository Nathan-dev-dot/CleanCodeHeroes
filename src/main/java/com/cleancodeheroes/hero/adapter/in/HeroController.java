package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroException;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    public String create(@RequestBody @Valid CreateHeroRequest createHeroRequest) {
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
        var heroId = (HeroId) commandBus.post(createHeroCommand);
        return heroId.value();
    }

    @GetMapping
    public GetHeroResponse getHero(@RequestParam String heroId) throws ResponseStatusException {
        try{
            var hero = (Hero) queryBus.post(new FindHeroQuery(heroId));
            return ResponseEntity
                    .ok()
                    .body(new GetHeroResponse(hero))
                    .getBody();
        } catch (HeroException e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}
