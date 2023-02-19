package com.cleancodeheroes.battle.application.port.out;

import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;

public interface CreateBattlePort {
    BattleId save (BattleResult battleResult) ;
}
