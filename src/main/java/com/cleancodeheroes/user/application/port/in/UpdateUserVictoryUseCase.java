package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.query.QueryHandler;
import com.cleancodeheroes.user.domain.User;

public interface UpdateUserVictoryUseCase extends QueryHandler<UpdateUserVictoriesQuery, User> {
}
