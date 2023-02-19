package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HealthPointTest {
    @Test
    public void shouldReturnAnHealthPointObject(){
        HealthPoint healthPoint = HealthPoint.of(0);
        Assertions.assertEquals(HealthPoint.class, healthPoint.getClass());
    }

    @Test
    public void shouldThrowIfHealthPointIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> HealthPoint.of(-1));
    }
    @Test
    public void shouldReturnHealthPointObjectWithValue1(){
        HealthPoint healthPoint = HealthPoint.of(1);
        Integer newHealthPoint = healthPoint.value();
        Assertions.assertEquals(1, newHealthPoint);
    }

    @Test
    public void shouldAddTenPercentOdHealthPoint(){
        HealthPoint healthPoint = HealthPoint.of(100);
        Integer newHealthPoint = healthPoint.increaseByFactor().value();
        Assertions.assertEquals(110, newHealthPoint);
    }


    @Test
    public void shouldAddTenPercentOdHealthPointWithoutDecimalValue(){
        HealthPoint healthPoint = HealthPoint.of(99);
        Integer newHealthPoint = healthPoint.increaseByFactor().value();
        Assertions.assertEquals(108, newHealthPoint);
    }
}

