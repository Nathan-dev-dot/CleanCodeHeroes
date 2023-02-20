package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public class FindBattleByIdQuery implements Query {
    public final String battleId;

    public FindBattleByIdQuery(String battleId) {
        this.battleId = battleId;
    }
}
