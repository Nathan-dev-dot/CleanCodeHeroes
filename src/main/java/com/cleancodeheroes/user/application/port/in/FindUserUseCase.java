package com.cleancodeheroes.user.application.port.in;
import com.cleancodeheroes.kernel.query.QueryHandler;
import com.cleancodeheroes.user.domain.User;

public interface FindUserUseCase extends QueryHandler<FindUserQuery, User> {
}
