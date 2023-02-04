package com.cleancodeheroes.user.application.port.out;

import com.cleancodeheroes.user.domain.User;

public interface FindUserPort {
    User load(UserId userId);
}
