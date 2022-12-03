package com.cleancodeheroes.hero.domain;

import java.util.HashMap;

public class Specialty {
    private final CharacterType type ;
    private final Integer baseHealthPoints ;
    private final Integer basePower ;
    private final Integer baseArmour ;
    private final HashMap<CharacterType, Integer> additionalDammage ;

    private Specialty(
            CharacterType type,
            Integer baseHealthPoints,
            Integer basePower,
            Integer baseArmour,
            HashMap<CharacterType, Integer> additionalDammage) {
        this.type = type;
        this.baseHealthPoints = baseHealthPoints;
        this.basePower = basePower;
        this.baseArmour = baseArmour;
        this.additionalDammage = additionalDammage;
    }

    public static Specialty Tank () {
        var additionnalDammageMap = new HashMap<CharacterType, Integer>();
        additionnalDammageMap.put(CharacterType.Sorcerer, 20);
        return new Specialty (
                CharacterType.Tank,
                1000,
                100,
                20,
                additionnalDammageMap
        ) ;
    }

    public static Specialty Assasin () {
        var additionnalDammageMap = new HashMap<CharacterType, Integer>();
        additionnalDammageMap.put(CharacterType.Tank, 30);
        return new Specialty (
                CharacterType.Assassin,
                800,
                200,
                5,
                additionnalDammageMap
        ) ;
    }

    public static Specialty Sorcerer () {
        var additionnalDammageMap = new HashMap<CharacterType, Integer>();
        additionnalDammageMap.put(CharacterType.Assassin, 25);
        return new Specialty (
                CharacterType.Sorcerer,
                700,
                150,
                10,
                additionnalDammageMap
        ) ;
    }

    public CharacterType getType() {
        return type;
    }

    public Integer getBaseHealthPoints() {
        return baseHealthPoints;
    }

    public Integer getBasePower() {
        return basePower;
    }

    public Integer getBaseArmour() {
        return baseArmour;
    }

    public HashMap<CharacterType, Integer> getAdditionalDammage() {
        return additionalDammage;
    }
}
