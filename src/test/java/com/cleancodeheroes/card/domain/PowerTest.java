package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerTest {
    @Test
    public void shouldReturnAnPowerObject(){
        Power power = new Power(500);
        Assertions.assertEquals(Power.class, power.getClass());
    }
    @Test
    public void shouldReturnPowerObjectWithValue500(){
        Power power = new Power(500);
        Assertions.assertEquals(500, power.getPower());
    }

    @Test
    public void shouldAdd200PowerPoint(){
        Power power = new Power(500);
        Assertions.assertEquals(700, power.addPower(200).getPower());
    }
    @Test
    public void shouldThrowAnArithmeticException(){
        Power power = new Power(500);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            power.addPower(0);
        });
    }
}
