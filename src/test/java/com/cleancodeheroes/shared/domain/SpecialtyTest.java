package com.cleancodeheroes.shared.domain;

import com.cleancodeheroes.hero.domain.CharacterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class SpecialtyTest {

    @Test
    public void shouldCreateTank () {
        var specialty = SpecialtyCharacteristics.Tank() ;
        Assertions.assertEquals(CharacterType.Tank, specialty.getType());
    }

    @Test
    public void shouldValidateTankBaseStats () {
        var tank = SpecialtyCharacteristics.Tank() ;
        Assertions.assertEquals(1000, tank.getBaseHealthPoints());
        Assertions.assertEquals(100, tank.getBasePower());
        Assertions.assertEquals(20, tank.getBaseArmour());
    }

    @Test
    public void shouldValidateTankDamageMap () {
        var tank = SpecialtyCharacteristics.Tank() ;
        Assertions.assertTrue(tank.getAdditionalDamage().containsKey(CharacterType.Sorcerer));
        Assertions.assertEquals(20, tank.getAdditionalDamage().get(CharacterType.Sorcerer));
    }

    @Test
    public void shouldCreateAssassin () {
        var specialty = SpecialtyCharacteristics.Assassin() ;
        Assertions.assertEquals(CharacterType.Assassin, specialty.getType());
    }

    @Test
    public void shouldValidateAssassinBaseStats () {
        var assasin = SpecialtyCharacteristics.Assassin() ;
        Assertions.assertEquals(800, assasin.getBaseHealthPoints());
        Assertions.assertEquals(200, assasin.getBasePower());
        Assertions.assertEquals(5, assasin.getBaseArmour());
    }

    @Test
    public void shouldValidateAssassinDamageMap () {
        var assassin = SpecialtyCharacteristics.Assassin() ;
        Assertions.assertTrue(assassin.getAdditionalDamage().containsKey(CharacterType.Tank));
        Assertions.assertEquals(30, assassin.getAdditionalDamage().get(CharacterType.Tank));
    }

    @Test
    public void shouldCreateSorcerer () {
        var specialty = SpecialtyCharacteristics.Sorcerer() ;
        Assertions.assertEquals(CharacterType.Sorcerer, specialty.getType());
    }

    @Test
    public void shouldValidateSorcererBaseStats () {
        var sorcerer = SpecialtyCharacteristics.Sorcerer() ;
        Assertions.assertEquals(700, sorcerer.getBaseHealthPoints());
        Assertions.assertEquals(150, sorcerer.getBasePower());
        Assertions.assertEquals(10, sorcerer.getBaseArmour());
    }

    @Test
    public void shouldValidateSorcererDamageMap () {
        var sorcerer = SpecialtyCharacteristics.Sorcerer() ;
        Assertions.assertTrue(sorcerer.getAdditionalDamage().containsKey(CharacterType.Assassin));
        Assertions.assertEquals(25, sorcerer.getAdditionalDamage().get(CharacterType.Assassin));
    }
}
