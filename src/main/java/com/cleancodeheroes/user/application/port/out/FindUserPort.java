package com.cleancodeheroes.user.application.port.out;

import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;

public interface FindUserPort {
    User load(UserId userId);
}
