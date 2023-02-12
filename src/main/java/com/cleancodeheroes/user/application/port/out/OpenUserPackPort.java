package com.cleancodeheroes.user.application.port.out;

import com.cleancodeheroes.user.domain.UserId;

public interface OpenUserPackPort {
    void open(UserId userId, String packType);
}
