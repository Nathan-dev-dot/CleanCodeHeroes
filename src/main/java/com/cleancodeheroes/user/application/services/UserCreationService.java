package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.CreateUserUseCase;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.domain.UserProps;

public final class UserCreationService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    public UserCreationService(CreateUserPort createUserPort){
        this.createUserPort = createUserPort;
    }

    @Override
    public UserId handle(CreateUserCommand command) {
        User newUser = new User(new UserProps(command.getUsername()));
        return this.createUserPort.save(newUser);
    }
}
