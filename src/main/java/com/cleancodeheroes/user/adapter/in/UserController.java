package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.UpdateUserCommand;
import com.cleancodeheroes.user.domain.PackType;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/user")
public final class UserController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserCommand createUserCommand = new CreateUserCommand(createUserRequest.username);
        var userId = (UserId) commandBus.post(createUserCommand);
        return userId.value();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetUserResponse getHero (@PathVariable("id") String id) {
        try{
            User user = (User) queryBus.post(new FindUserQuery(id));
            return ResponseEntity
                    .ok()
                    .body(new GetUserResponse(user))
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }

    @PutMapping(value = "pack/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void openUserPack(
            @PathVariable("id") String id,
            @RequestBody @Valid OpenUserPackRequest openUserPackRequest){
        try{
            User user = (User) queryBus.post(new FindUserQuery(id));
            user.hasMinimalNumberOfToken(PackType.valueOf(openUserPackRequest.packType));
            ArrayList<Hero> heroes = (ArrayList<Hero>) queryBus.post(new FindHeroesQuery());
            ArrayList<Hero> heroPull = (ArrayList<Hero>) commandBus.post(new OpenUserPackCommand(heroes));
            ArrayList<CardId> cards = new ArrayList<>();
            heroPull.forEach(hero -> {
                CreateCardCommand createCardCommand = new CreateCardCommand(hero);
                cards.add((CardId) commandBus.post(createCardCommand));
            });
            user.retrieveTokenByPackType(PackType.valueOf(openUserPackRequest.packType));
            user.updateDeck(cards);
            commandBus.post(new UpdateUserCommand(user));
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}
