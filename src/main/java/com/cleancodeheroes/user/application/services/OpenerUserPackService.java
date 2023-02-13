package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.OpenUserPackUseCase;

import java.util.ArrayList;

public class OpenerUserPackService implements OpenUserPackUseCase {

    @Override
    public ArrayList<Hero> handle(OpenUserPackCommand command) {
        return command.heroes; //TODO
    }
}
