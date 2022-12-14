package com.cleancodeheroes.hero.domain;

import java.util.Objects;
import java.util.UUID;

public class HeroId {
    private final UUID id;

    private HeroId(UUID id) {
        this.id = id;
    }

    public static HeroId of (UUID uuid) {
        return new HeroId(uuid);
    }

    public UUID value() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeroId heroId)) return false;
        return id.equals(heroId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
