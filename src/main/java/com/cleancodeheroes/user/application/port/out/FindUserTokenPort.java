package com.cleancodeheroes.user.application.port.out;

import com.cleancodeheroes.user.adapter.out.UserNotFoundException;
import com.cleancodeheroes.user.domain.UserId;

public interface FindUserTokenPort {
    Integer loadUserToken(UserId userId) throws UserNotFoundException;
}
