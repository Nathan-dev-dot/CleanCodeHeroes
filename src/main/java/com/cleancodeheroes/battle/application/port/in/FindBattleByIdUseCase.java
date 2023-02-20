package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.kernel.query.QueryHandler;

public interface FindBattleByIdUseCase extends QueryHandler<FindBattleByIdQuery, BattleResult> {
}
