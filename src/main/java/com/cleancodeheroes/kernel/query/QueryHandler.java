package com.cleancodeheroes.kernel.query;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query) throws Exception;
}
