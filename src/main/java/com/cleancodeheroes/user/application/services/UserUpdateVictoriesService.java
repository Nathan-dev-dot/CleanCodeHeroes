package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.UpdateUserVictoriesQuery;
import com.cleancodeheroes.user.application.port.in.UpdateUserVictoryUseCase;
import com.cleancodeheroes.user.domain.User;

public class UserUpdateVictoriesService implements UpdateUserVictoryUseCase {
    @Override
    public User handle(UpdateUserVictoriesQuery query) {
        User user = query.user;
        user.addVictory();
        if (user.shouldReceiveNewToken())
            user.addToken();
        return user;
    }
}
