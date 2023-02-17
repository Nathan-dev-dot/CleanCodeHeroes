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
    public void shouldAddTenPercentOfPowerPoint(){
        Power power = new Power(500);
        Assertions.assertEquals(550, power.addTenPercentOfPowerPower().getPower());
    }
    @Test
    public void shouldAddTenPercentOfPowerPointWithoutDecimalValue(){
        Power power = new Power(501);
        Assertions.assertEquals(551, power.addTenPercentOfPowerPower().getPower());
    }
}
