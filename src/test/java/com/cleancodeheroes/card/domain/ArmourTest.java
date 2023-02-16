package com.cleancodeheroes.card.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmourTest {

    @Test
    public void shouldReturnAnArmourObject(){
        Armour armour = new Armour(1);
        Assertions.assertEquals(Armour.class, armour.getClass());
    }
    @Test
    public void shouldReturnArmourObjectWithValue1(){
        Armour armour = new Armour(1);
        Assertions.assertEquals(1, armour.getArmour());
    }

    @Test
    public void shouldAddOneArmourPoint(){
        Armour armour = new Armour(1);
        Assertions.assertEquals(2, armour.addArmour(1).getArmour());
    }
    @Test
    public void shouldThrowAnArithmeticException(){
        Armour armour = new Armour(1);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            armour.addArmour(0);
        });
    }
}
