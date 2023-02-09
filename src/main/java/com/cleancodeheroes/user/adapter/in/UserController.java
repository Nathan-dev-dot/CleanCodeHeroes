package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/user")
public final class UserController {
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHero (@PathVariable("id") String id) {
        try{
            User user = (User) queryBus.post(new FindUserQuery(id));
            GetUserResponse response = GetUserResponse.of(user);
            return new JSONObject(response).toString();
        } catch (Exception e) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}
