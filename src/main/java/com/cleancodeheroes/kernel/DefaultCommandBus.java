package com.cleancodeheroes.kernel;

import com.cleancodeheroes.kernel.command.Command;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.command.CommandHandler;

import java.util.Map;

final class DefaultCommandBus<C extends Command> implements CommandBus<C> {

    private final Map<Class<C>, CommandHandler> registry;

    DefaultCommandBus(Map<Class<C>, CommandHandler> registry) {
        this.registry = registry;
    }

    @Override
    public <R> R post(C command) {
        var commandHandler = registry.get(command.getClass());
        return (R) commandHandler.handle(command);
    }

    @Override
    public <R> void register(Class<C> commandClass, CommandHandler<C, R> commandHandler) {
        registry.putIfAbsent(commandClass, commandHandler);
    }
}
