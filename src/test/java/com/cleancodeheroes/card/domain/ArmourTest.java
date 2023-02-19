package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArmourTest {

    @Test
    public void shouldReturnAnArmourObject(){
        Armour armour = Armour.of(1);
        Assertions.assertEquals(Armour.class, armour.getClass());
    }
    
    @Test
    public void shouldThrowIfArmourIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Armour.of(-1));
    }
    @Test
    public void shouldReturnArmourObjectWithValue1(){
        Armour armour = Armour.of(1);
        Assertions.assertEquals(1, armour.getArmour());
    }

    @Test
    public void shouldAddTenPercentOfArmourPoint(){
        Armour armour = Armour.of(100);
        Integer newArmourPoint = armour.increaseByFactor().getArmour();
        Assertions.assertEquals(110, newArmourPoint);
    }

    @Test
    public void shouldAddTenPercentOfArmourPointWithoutDecimalValue(){
        Armour armour = Armour.of(101);
        Integer newArmourPoint = armour.increaseByFactor().getArmour();
        Assertions.assertEquals(111, newArmourPoint);
    }
}
