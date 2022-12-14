package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.kernel.command.CommandHandler;

public interface CreateHeroUseCase extends CommandHandler<CreateHeroCommand, HeroId> {
}
