package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.kernel.query.Query;
import com.cleancodeheroes.user.domain.UserId;

public class FindBattleByUserIdQuery implements Query {
    public final UserId userId;

    public FindBattleByUserIdQuery(String userId) {
        this.userId = UserId.of(userId);
    }
}
