package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public class FindHeroQuery implements Query {
    public final String heroId;

    public FindHeroQuery(String heroId) {
        this.heroId = heroId;
    }
}
