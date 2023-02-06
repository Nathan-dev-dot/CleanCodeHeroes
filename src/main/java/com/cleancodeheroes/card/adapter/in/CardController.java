package com.cleancodeheroes.card.adapter.in;

import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/card")
public final class CardController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public CardController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create (@RequestBody @Valid CreateCardRequest createCardRequest) {
        try {
            Hero hero = (Hero) queryBus.post(new FindHeroQuery(createCardRequest.baseHeroId));
            CreateCardCommand createCardCommand = new CreateCardCommand(hero);
            CardId cardId = (CardId) commandBus.post(createCardCommand);
            return cardId.value();
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }
}
