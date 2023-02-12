package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.OpenUserPackUseCase;

public class OpenerUserPackService implements OpenUserPackUseCase {

    @Override
    public Void handle(OpenUserPackCommand command) {
        return null;
    }
}
