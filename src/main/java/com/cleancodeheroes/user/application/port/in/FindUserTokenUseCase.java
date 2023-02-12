package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.query.QueryHandler;

public interface FindUserTokenUseCase extends QueryHandler<FindUserTokenQuery, Integer> { }
