package com.cleancodeheroes.battle.application.port.out;

import com.cleancodeheroes.battle.adapter.out.NoBattleFoundException;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.user.domain.UserId;

import java.util.ArrayList;
import java.util.List;

public interface FindBattleByUserIdPort {
    ArrayList<BattleResult> loadBattleByUserId(UserId userId) throws NoBattleFoundException;
}
