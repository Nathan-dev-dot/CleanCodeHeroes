package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.CreateUserUseCase;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.domain.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public final class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    public CreateUserService(CreateUserPort createUserPort){
        this.createUserPort = createUserPort;
    }
    @Override
    public UserId handle(CreateUserCommand command) {
        final ArrayList<String> cards = new ArrayList<>();
        UserProps userProps =  new UserProps(
                UserId.of(new ObjectId().toString()),
                command.getUsername(),
                new Token(4),
                new Deck(cards)
        );
        User newUser = new User(userProps);
        return this.createUserPort.save(newUser);
    }
}
