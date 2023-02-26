package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.UpdateUserCommand;
import com.cleancodeheroes.user.application.port.in.UpdateUserUseCase;
import com.cleancodeheroes.user.application.port.out.UpdateUserPort;
import com.cleancodeheroes.user.domain.UserId;

public class UserUpdatingService implements UpdateUserUseCase {

    private final UpdateUserPort updateUserPort;

    public UserUpdatingService(UpdateUserPort updateUserPort) {
        this.updateUserPort = updateUserPort;
    }

    @Override
    public UserId handle(UpdateUserCommand command) {
        return updateUserPort.update(command.user);
    }
}
