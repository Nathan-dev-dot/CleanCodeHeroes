package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.command.Command;
import com.cleancodeheroes.user.domain.User;

public class UpdateUserCommand implements Command {
    public final User user;

    public UpdateUserCommand(User user) {
        this.user = user;
    }
}
