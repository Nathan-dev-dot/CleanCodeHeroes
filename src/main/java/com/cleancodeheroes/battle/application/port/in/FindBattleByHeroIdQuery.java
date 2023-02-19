package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.query.Query;

public class FindBattleByHeroIdQuery implements Query {
    public final HeroId heroId;

    public FindBattleByHeroIdQuery(String heroId) {
        this.heroId = HeroId.of(heroId);
    }
}
