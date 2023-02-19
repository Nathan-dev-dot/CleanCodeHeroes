package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.kernel.query.QueryHandler;

import java.util.ArrayList;

public interface FindBattleByUserIdUseCase extends QueryHandler<FindBattleByUserIdQuery, ArrayList<BattleResult>> {
}
