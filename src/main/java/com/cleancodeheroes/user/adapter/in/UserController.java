package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.hero.adapter.in.CreateHeroRequest;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.domain.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private UserController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody @Valid CreateUserRequest createUserRequest) {
        CreateUserCommand createUserCommand = new CreateUserCommand(createUserRequest.username);
        var userId = (UserId) commandBus.post(createUserCommand);
        return userId.value();
    }

}
