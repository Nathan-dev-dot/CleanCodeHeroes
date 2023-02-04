package com.cleancodeheroes.hero.adapter.in;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return heroId.value();
    }

    @GetMapping("/{id}")
    public GetHeroResponse getHero (@PathVariable("id") String id) {
        try{
            Optional<Hero> hero = (Optional<Hero>) queryBus.post(new FindHeroQuery(id));
            return ResponseEntity
                    .ok()
                    .body(new GetHeroResponse(hero.get()))
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }

    @GetMapping()
    public List<GetHeroResponse> getHeroes() throws ResponseStatusException {
        try{
            ArrayList<Hero> heroes = (ArrayList<Hero>) queryBus.post(new FindHeroesQuery());
            return ResponseEntity
                    .ok()
                    .body(heroes.stream().map(GetHeroResponse::new).toList())
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}
