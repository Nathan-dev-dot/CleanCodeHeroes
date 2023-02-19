package com.cleancodeheroes.shared.domain;

import com.cleancodeheroes.hero.domain.CharacterType;

import java.util.HashMap;

public final class SpecialtyCharacteristics {
    private final CharacterType type ;
    private final Integer baseHealthPoints ;
    private final Integer basePower ;
    private final Integer baseArmour ;
    private final HashMap<CharacterType, Integer> additionalDamage ;

    private SpecialtyCharacteristics(
            CharacterType type,
            Integer baseHealthPoints,
            Integer basePower,
            Integer baseArmour,
            HashMap<CharacterType, Integer> additionalDamage) {
        this.type = type;
        this.baseHealthPoints = baseHealthPoints;
        this.basePower = basePower;
        this.baseArmour = baseArmour;
        this.additionalDamage = additionalDamage;
    }

    public static SpecialtyCharacteristics of (CharacterType characterType) throws IllegalArgumentException {
        switch (characterType) {
            case Tank -> {
                return SpecialtyCharacteristics.Tank();
            }
            case Assassin -> {
                return SpecialtyCharacteristics.Assassin();
            }
            case Sorcerer -> {
                return SpecialtyCharacteristics.Sorcerer();
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    public static SpecialtyCharacteristics Tank () {
        var additionalDamageMap = new HashMap<CharacterType, Integer>();
        additionalDamageMap.put(CharacterType.Sorcerer, 20);
        return new SpecialtyCharacteristics(
                CharacterType.Tank,
                1000,
                100,
                20,
                additionalDamageMap
        ) ;
    }

    public static SpecialtyCharacteristics Assassin() {
        var additionalDamageMap = new HashMap<CharacterType, Integer>();
        additionalDamageMap.put(CharacterType.Tank, 30);
        return new SpecialtyCharacteristics(
                CharacterType.Assassin,
                800,
                200,
                5,
                additionalDamageMap
        ) ;
    }

    public static SpecialtyCharacteristics Sorcerer () {
        var additionalDamageMap = new HashMap<CharacterType, Integer>();
        additionalDamageMap.put(CharacterType.Assassin, 25);
        return new SpecialtyCharacteristics(
                CharacterType.Sorcerer,
                700,
                150,
                10,
                additionalDamageMap
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

    public HashMap<CharacterType, Integer> getAdditionalDamage() {
        return additionalDamage;
    }
}
