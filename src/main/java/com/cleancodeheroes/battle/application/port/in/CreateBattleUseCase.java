package com.cleancodeheroes.battle.application.port.in;

import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.kernel.command.CommandHandler;

public interface CreateBattleUseCase extends CommandHandler<CreateBattleCommand, BattleId> {
}
