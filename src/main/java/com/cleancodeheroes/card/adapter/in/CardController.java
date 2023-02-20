package com.cleancodeheroes.card.adapter.in;

import com.cleancodeheroes.card.application.port.in.FindCardQuery;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    @GetMapping("/{id}")
    public GetCardResponse findOne (@PathVariable("id") String id) {
        try {
            Card card = (Card) queryBus.post(new FindCardQuery(id));
            return ResponseEntity
                    .ok()
                    .body(new GetCardResponse(card))
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Hero " + id + " not found");
        }
    }
}
