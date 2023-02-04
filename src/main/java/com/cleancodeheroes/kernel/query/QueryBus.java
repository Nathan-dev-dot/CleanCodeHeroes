package com.cleancodeheroes.kernel.query;

public interface QueryBus<Q extends Query> {
    <R> R post(Q query) throws Exception;

    <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler);
}
