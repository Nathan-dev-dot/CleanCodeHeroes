package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.command.CommandHandler;
import com.cleancodeheroes.user.domain.UserId;

public interface UpdateUserUseCase extends CommandHandler<UpdateUserCommand, UserId> {
}
