package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.kernel.query.QueryHandler;

import java.util.ArrayList;

public interface FindHeroesUseCase extends QueryHandler<FindHeroesQuery, ArrayList<Hero>> {
}