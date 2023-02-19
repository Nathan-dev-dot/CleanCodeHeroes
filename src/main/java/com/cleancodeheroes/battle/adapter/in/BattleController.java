package com.cleancodeheroes.battle.adapter.in;

import com.cleancodeheroes.battle.application.port.in.FindBattleByHeroIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByUserIdQuery;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.card.adapter.in.CreateCardRequest;
import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/battle")
public class BattleController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public BattleController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create (@RequestBody @Valid CreateBattleRequest createBattleRequest) {
        try {
            System.out.println("createBattleRequest.attackerId = " + createBattleRequest.attackerId);
            return "done";
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }

    @GetMapping(value = {"/user/{userId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<BattleResult> getBattleByUserId (@PathVariable("userId") String userId) {
        try {
            return (ArrayList<BattleResult>) queryBus.post(new FindBattleByUserIdQuery(userId));
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }

    @GetMapping(value = {"/hero/{heroId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<BattleResult> getBattleByHeroId (@PathVariable("heroId") String heroId) {
        try {
            return (ArrayList<BattleResult>) queryBus.post(new FindBattleByHeroIdQuery(heroId));
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }
}
