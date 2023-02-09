package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.kernel.command.CommandHandler;

public interface CreateCardUseCase extends CommandHandler<CreateCardCommand, CardId> {
}
