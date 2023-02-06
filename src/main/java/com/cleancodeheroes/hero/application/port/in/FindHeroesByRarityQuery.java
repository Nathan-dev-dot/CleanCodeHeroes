package com.cleancodeheroes.hero.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public final class FindHeroesByRarityQuery implements Query {
    public final String rarity;

    public FindHeroesByRarityQuery(String rarity) { this.rarity = rarity; }
}
