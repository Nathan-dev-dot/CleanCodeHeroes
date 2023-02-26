package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.adapter.out.UserNotFoundException;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.application.port.in.FindUserUseCase;
import com.cleancodeheroes.user.application.port.out.FindUserPort;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;

public final class UserFindingService implements FindUserUseCase {

    private final FindUserPort findHeroPort;

    public UserFindingService(FindUserPort findHeroPort) {
        this.findHeroPort = findHeroPort;
    }

    @Override
    public User handle(FindUserQuery query) throws UserNotFoundException {
        return this.findHeroPort.load(UserId.of(query.userId));
    }
}
