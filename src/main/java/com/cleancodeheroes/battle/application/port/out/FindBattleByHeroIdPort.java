package com.cleancodeheroes.battle.application.port.out;

import com.cleancodeheroes.battle.adapter.out.NoBattleFoundException;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.hero.domain.HeroId;

import java.util.ArrayList;

public interface FindBattleByHeroIdPort {
    ArrayList<BattleResult> loadBattleByHeroId(HeroId heroId) throws NoBattleFoundException;
}
