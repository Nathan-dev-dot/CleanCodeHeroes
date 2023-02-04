package com.cleancodeheroes.user.application.port.out;

public interface CreateUserPort {
    UserId save(User user);
}
