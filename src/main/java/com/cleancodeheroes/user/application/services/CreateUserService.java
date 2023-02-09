package com.cleancodeheroes.user.application.services;
import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.CreateUserUseCase;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.domain.*;
import com.cleancodeheroes.utils.IdUtils;
import org.bson.types.ObjectId;

public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;

    public CreateUserService(CreateUserPort createUserPort){
        this.createUserPort = createUserPort;
    }
    @Override
    public UserId handle(CreateUserCommand command) {
        UserProps userProps =  new UserProps(
                UserId.of(new ObjectId().toString()),
                command.getUsername(),
                Token.of(4),
                new Deck()
        );
        User newUser = User.of(userProps);
        System.out.println("newUser = " + newUser);
        return this.createUserPort.save(newUser);
    }
}
