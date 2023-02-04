package com.cleancodeheroes.kernel;

import com.cleancodeheroes.kernel.query.Query;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.kernel.query.QueryHandler;

import java.util.Map;

final class DefaultQueryBus<Q extends Query> implements QueryBus<Q> {

    private final Map<Class<Q>, QueryHandler> registry;


    DefaultQueryBus(Map<Class<Q>, QueryHandler> registry) {
        this.registry = registry;
    }

    @Override
    public <R> R post(Q query) throws Exception {
        var queryHandler = registry.get(query.getClass());
        return (R) queryHandler.handle(query);
    }


    @Override
    public <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler) {
        registry.putIfAbsent(queryClass, queryHandler);
    }
}
