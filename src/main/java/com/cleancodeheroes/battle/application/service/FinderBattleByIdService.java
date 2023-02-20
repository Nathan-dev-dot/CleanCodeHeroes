package com.cleancodeheroes.battle.application.service;

import com.cleancodeheroes.battle.adapter.out.BattleNotFoundException;
import com.cleancodeheroes.battle.application.port.in.FindBattleByIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByIdUseCase;
import com.cleancodeheroes.battle.application.port.out.FindBattleByIdPort;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;

public class FinderBattleByIdService implements FindBattleByIdUseCase {
    private final FindBattleByIdPort findBattleByIdPort;

    public FinderBattleByIdService(FindBattleByIdPort finderBattleByIdService) {
        this.findBattleByIdPort = finderBattleByIdService;
    }

    @Override
    public BattleResult handle(FindBattleByIdQuery query) throws Exception {
        BattleId battleId = BattleId.of(query.battleId);
        return this.findBattleByIdPort.loadBattleById(battleId);
    }
}
