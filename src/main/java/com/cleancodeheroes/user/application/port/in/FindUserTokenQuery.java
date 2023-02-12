package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public class FindUserTokenQuery implements Query {
    public final String userId;

    public FindUserTokenQuery(String userId) {
        this.userId = userId;
    }
}
