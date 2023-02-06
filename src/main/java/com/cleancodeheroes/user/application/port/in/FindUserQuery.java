package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public final class FindUserQuery implements Query {
    public final String userId;

    public FindUserQuery(String userId) {
        this.userId = userId;
    }
}
