package com.cleancodeheroes.battle.application.port.out;

import com.cleancodeheroes.battle.adapter.out.NoBattleFoundException;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.user.domain.UserId;

import java.util.ArrayList;

public interface FindBattleByHeroIdPort {
    ArrayList<BattleResult> loadBattleByHeroId(HeroId heroId) throws NoBattleFoundException;
}
