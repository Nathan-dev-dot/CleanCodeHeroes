package com.cleancodeheroes.user.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.command.CommandHandler;

import java.util.ArrayList;

public interface OpenUserPackUseCase extends CommandHandler<OpenUserPackCommand, ArrayList<Hero>> {
}
