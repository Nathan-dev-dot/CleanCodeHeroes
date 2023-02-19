package com.cleancodeheroes.battle.application.service;

import com.cleancodeheroes.battle.application.port.in.CreateBattleCommand;
import com.cleancodeheroes.battle.application.port.in.CreateBattleUseCase;
import com.cleancodeheroes.battle.application.port.out.CreateBattlePort;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.card.domain.Card;

public class BattleCreationService implements CreateBattleUseCase {
    private final CreateBattlePort createBattlePort;

    public BattleCreationService (CreateBattlePort createBattlePort) { this.createBattlePort = createBattlePort; }

    @Override
    public BattleId handle(CreateBattleCommand command) {
        Battle battle = command.getBattle();
        Card winner = battle.getWinner();
        Card loser = battle.getLoser();
        BattleResult battleResult = new BattleResult(winner, loser);
        return this.createBattlePort.save(battleResult);
    }
}
