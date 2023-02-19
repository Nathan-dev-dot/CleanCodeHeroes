package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerTest {
    @Test
    public void shouldReturnAnPowerObject(){
        Power power = Power.of(500);
        Assertions.assertEquals(Power.class, power.getClass());
    }

    @Test
    public void shouldThrowIfNegativePower () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Power.of(-1));
    }
    @Test
    public void shouldReturnPowerObjectWithValue500(){
        Power power = Power.of(500);
        Assertions.assertEquals(500, power.getPower());
    }

    @Test
    public void shouldAddTenPercentOfPowerPoint(){
        Power power = Power.of(500);
        Integer newPowerPoint = power.increaseByFactor().getPower();
        Assertions.assertEquals(550, newPowerPoint);
    }
    @Test
    public void shouldAddTenPercentOfPowerPointWithoutDecimalValue(){
        Power power = Power.of(501);
        Integer newPowerPoint = power.increaseByFactor().getPower();
        Assertions.assertEquals(551, newPowerPoint);
    }
}
