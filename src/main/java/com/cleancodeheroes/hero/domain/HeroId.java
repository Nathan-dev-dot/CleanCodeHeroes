package com.cleancodeheroes.hero.domain;

import org.bson.types.ObjectId;

import java.util.Objects;

public final class HeroId {
    private final String id;

    private HeroId(String id) {
        this.id = id;
    }

    public static HeroId of (String stringId) throws IllegalArgumentException {
        if (ObjectId.isValid(stringId))
            return new HeroId(stringId);
        throw new IllegalArgumentException(stringId);
    }

    public static HeroId of (ObjectId object) {
        return new HeroId(object.toString());
    }


    public String value() {
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
