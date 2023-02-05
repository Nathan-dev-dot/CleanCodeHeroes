package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.kernel.command.Command;

import java.util.Objects;

public final class CreateUserCommand implements Command {
    private final String username;

    public CreateUserCommand(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserCommand that)) return false;
        return getUsername().equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername());
    }
}
