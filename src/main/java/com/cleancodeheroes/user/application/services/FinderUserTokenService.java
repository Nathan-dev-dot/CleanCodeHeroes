package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.FindUserTokenQuery;
import com.cleancodeheroes.user.application.port.in.FindUserTokenUseCase;
import com.cleancodeheroes.user.application.port.out.FindUserPort;
import com.cleancodeheroes.user.application.port.out.FindUserTokenPort;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;

public class FinderUserTokenService implements FindUserTokenUseCase {

    private final FindUserTokenPort findUserPort;

    public FinderUserTokenService(FindUserTokenPort findUserPort) {
        this.findUserPort = findUserPort;
    }

    @Override
    public Integer handle(FindUserTokenQuery query) throws Exception {
        UserId userId = UserId.of(query.userId);
        return this.findUserPort.loadUserToken(userId);
    }

}
