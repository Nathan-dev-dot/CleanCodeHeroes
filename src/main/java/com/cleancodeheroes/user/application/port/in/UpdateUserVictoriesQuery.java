package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.query.Query;
import com.cleancodeheroes.user.domain.User;

public class UpdateUserVictoriesQuery implements Query {
    public final User user;

    public UpdateUserVictoriesQuery(User user) {
        this.user = user;
    }
}
