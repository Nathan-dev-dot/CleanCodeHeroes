package com.cleancodeheroes.battle.application.port.out;

import com.cleancodeheroes.battle.adapter.out.BattleNotFoundException;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;

public interface FindBattleByIdPort {
    BattleResult loadBattleById(BattleId battleId) throws BattleNotFoundException;
}
