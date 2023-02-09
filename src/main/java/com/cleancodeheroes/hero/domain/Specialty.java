package com.cleancodeheroes.hero.domain;

import java.util.Objects;

public final class Specialty {
    private final CharacterType specialty ;

    private Specialty(CharacterType specialty) {
        this.specialty = specialty;
    }

    public static Specialty of (String specialty) throws IllegalArgumentException {
        return new Specialty(CharacterType.valueOf(specialty));
    }

    public CharacterType value() {
        return specialty;
    }

    @Override
    public String toString(){
        return this.specialty.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty specialty1)) return false;
        return specialty == specialty1.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialty);
    }
}
