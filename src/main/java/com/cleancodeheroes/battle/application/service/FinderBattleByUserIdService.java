package com.cleancodeheroes.battle.application.service;

import com.cleancodeheroes.battle.application.port.in.FindBattleByUserIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByUserIdUseCase;
import com.cleancodeheroes.battle.application.port.out.FindBattleByUserIdPort;
import com.cleancodeheroes.battle.domain.BattleResult;

import java.util.ArrayList;

public class FinderBattleByUserIdService implements FindBattleByUserIdUseCase {
    private final FindBattleByUserIdPort findBattleByUserIdPort;

    public FinderBattleByUserIdService(FindBattleByUserIdPort findBattleByUserIdPort) {
        this.findBattleByUserIdPort = findBattleByUserIdPort;
    }


    @Override
    public ArrayList<BattleResult> handle(FindBattleByUserIdQuery query) throws Exception {
        return this.findBattleByUserIdPort.loadBattleByUserId(query.userId);
    }
}
