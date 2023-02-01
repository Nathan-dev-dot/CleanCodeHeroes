package com.cleancodeheroes.kernel;

import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

public final class BusFactory {

    private BusFactory() {
        throw new AssertionError();
    }

    public static CommandBus defaultCommandBus() {
        return new DefaultCommandBus(new HashMap<>());
    }

    public static QueryBus defaultQueryBus() {
        return new DefaultQueryBus(new HashMap<>());
    }
}
