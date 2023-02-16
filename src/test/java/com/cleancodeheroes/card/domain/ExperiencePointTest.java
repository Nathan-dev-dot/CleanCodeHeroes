package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExperiencePointTest {
    @Test
    public void shouldReturnAnExperiencePointObject(){
        ExperiencePoint experiencePoint = new ExperiencePoint(1);
        Assertions.assertEquals(ExperiencePoint.class, experiencePoint.getClass());
    }
    @Test
    public void shouldReturnExperiencePointObjectWithValue1(){
        ExperiencePoint experiencePoint = new ExperiencePoint(1);
        Assertions.assertEquals(1, experiencePoint.getExperiencePoint());
    }

    @Test
    public void shouldAddOneExperiencePointPoint(){
        ExperiencePoint experiencePoint = new ExperiencePoint(1);
        Assertions.assertEquals(2, experiencePoint.addExperiencePoint(1).getExperiencePoint());
    }
    @Test
    public void shouldThrowAnArithmeticException(){
        ExperiencePoint experiencePoint = new ExperiencePoint(1);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            experiencePoint.addExperiencePoint(0);
        });
    }
}
