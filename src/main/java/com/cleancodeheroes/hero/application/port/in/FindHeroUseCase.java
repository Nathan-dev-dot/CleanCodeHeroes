package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.query.QueryHandler;

import java.util.Optional;

public interface FindHeroUseCase extends QueryHandler<FindHeroQuery, Optional<Hero>> {
}