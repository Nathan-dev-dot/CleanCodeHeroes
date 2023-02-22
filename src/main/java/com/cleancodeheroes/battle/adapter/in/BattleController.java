package com.cleancodeheroes.battle.adapter.in;

import com.cleancodeheroes.battle.application.port.in.CreateBattleCommand;
import com.cleancodeheroes.battle.application.port.in.FindBattleByHeroIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByUserIdQuery;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.card.application.port.in.FindCardQuery;
import com.cleancodeheroes.card.application.port.in.UpdateCardCommand;
import com.cleancodeheroes.card.application.port.in.UpgradeCardQuery;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.application.port.in.UpdateUserCommand;
import com.cleancodeheroes.user.application.port.in.UpdateUserVictoriesQuery;
import com.cleancodeheroes.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
            Card attackerCard = getCardByCardId(createBattleRequest.attackerId);
            Card defenderCard = getCardByCardId(createBattleRequest.defenderId);
            Battle newBattle = createBattle(attackerCard, defenderCard);
            BattleId battleId = (BattleId) commandBus.post(new CreateBattleCommand(newBattle));
            BattleResult battle = (BattleResult) queryBus.post(new FindBattleByIdQuery(battleId.value()));
            Card winnerCard = newBattle.getWinner();
            Card winnerCardUpdated = (Card) queryBus.post(new UpgradeCardQuery(winnerCard));
            commandBus.post(new UpdateCardCommand(winnerCardUpdated));
            User winnerUser = (User) queryBus.post(new FindUserQuery(battle.winnerUserId.value()));
            winnerUser = (User) queryBus.post(new UpdateUserVictoriesQuery(winnerUser));
            commandBus.post(new UpdateUserCommand(winnerUser));
            System.out.println("Win user update");
            return battleId.value();
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }

    private Battle createBattle(Card attackerCard, Card defenderCard) {
        return new Battle(attackerCard, defenderCard);
    }

    private Card getCardByCardId(String cardId) throws Exception {
        return (Card) queryBus.post(new FindCardQuery(cardId));
    }

    @GetMapping(value = {"/{battleId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public BattleResponse getBattleById(@PathVariable("battleId") String battleId) {
        try {
            BattleResult battle = (BattleResult) queryBus.post(new FindBattleByIdQuery(battleId));
            return ResponseEntity
                    .ok()
                    .body(BattleResponse.of(battle))
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }

    @GetMapping(value = {"/user/{userId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BattleResponse> getBattleByUserId (@PathVariable("userId") String userId) {
        try {
            ArrayList<BattleResult> battleResults = (ArrayList<BattleResult>) queryBus.post(new FindBattleByUserIdQuery(userId));
            return ResponseEntity
                    .ok()
                    .body(battleResults.stream().map((battleResult -> BattleResponse.of(battleResult))).toList())
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }

    @GetMapping(value = {"/hero/{heroId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BattleResponse> getBattleByHeroId (@PathVariable("heroId") String heroId) {
        try {
            ArrayList<BattleResult> battleResults =  (ArrayList<BattleResult>) queryBus.post(new FindBattleByHeroIdQuery(heroId));
            return ResponseEntity
                    .ok()
                    .body(battleResults.stream().map((battleResult -> BattleResponse.of(battleResult))).toList())
                    .getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid parameters");
        }
    }
}
