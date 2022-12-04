package com.cleancodeheroes.hero.domain;

public class Specialty {
    private final CharacterType specialty ;

    private Specialty(CharacterType specialty) {
        this.specialty = specialty;
    }

    public static Specialty of (String specialty) {
        return new Specialty(CharacterType.valueOf(specialty));
    }

    public CharacterType value() {
        return specialty;
    }
}
