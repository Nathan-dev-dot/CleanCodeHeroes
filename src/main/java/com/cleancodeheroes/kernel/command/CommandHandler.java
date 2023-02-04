package com.cleancodeheroes.kernel.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
