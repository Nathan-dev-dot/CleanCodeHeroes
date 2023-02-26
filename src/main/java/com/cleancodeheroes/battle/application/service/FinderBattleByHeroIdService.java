package com.cleancodeheroes.battle.application.service;

import com.cleancodeheroes.battle.application.port.in.FindBattleByHeroIdQuery;
import com.cleancodeheroes.battle.application.port.in.FindBattleByHeroIdUseCase;
import com.cleancodeheroes.battle.application.port.out.FindBattleByHeroIdPort;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.hero.domain.HeroId;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class FinderBattleByHeroIdService implements FindBattleByHeroIdUseCase {
    private final FindBattleByHeroIdPort findBattleByUserIdPort;

    public FinderBattleByHeroIdService(FindBattleByHeroIdPort findBattleByUserIdPort) {
        this.findBattleByUserIdPort = findBattleByUserIdPort;
    }

    @Override
    public ArrayList<BattleResult> handle(FindBattleByHeroIdQuery query) throws Exception {
        HeroId heroId = HeroId.of(query.heroId);
        return findBattleByUserIdPort.loadBattleByHeroId(heroId);
    }
}
