package com.cleancodeheroes.hero.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpecialtyTest {

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
    public void shouldValidateTankDammageMap () {
        var tank = SpecialtyCharacteristics.Tank() ;
        Assertions.assertTrue(tank.getAdditionalDammage().containsKey(CharacterType.Sorcerer));
        Assertions.assertEquals(20, tank.getAdditionalDammage().get(CharacterType.Sorcerer));
    }

    @Test
    public void shouldCreateAssassin () {
        var specialty = SpecialtyCharacteristics.Assasin() ;
        Assertions.assertEquals(CharacterType.Assassin, specialty.getType());
    }

    @Test
    public void shouldValidateAssassinBaseStats () {
        var assasin = SpecialtyCharacteristics.Assasin() ;
        Assertions.assertEquals(800, assasin.getBaseHealthPoints());
        Assertions.assertEquals(200, assasin.getBasePower());
        Assertions.assertEquals(5, assasin.getBaseArmour());
    }

    @Test
    public void shouldValidateAssassinDammageMap () {
        var assassin = SpecialtyCharacteristics.Assasin() ;
        Assertions.assertTrue(assassin.getAdditionalDammage().containsKey(CharacterType.Tank));
        Assertions.assertEquals(30, assassin.getAdditionalDammage().get(CharacterType.Tank));
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
    public void shouldValidateSorcererDammageMap () {
        var sorcerer = SpecialtyCharacteristics.Sorcerer() ;
        Assertions.assertTrue(sorcerer.getAdditionalDammage().containsKey(CharacterType.Assassin));
        Assertions.assertEquals(25, sorcerer.getAdditionalDammage().get(CharacterType.Assassin));
    }
}
