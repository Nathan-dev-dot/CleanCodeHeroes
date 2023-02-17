package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExperiencePointTest {
    @Test
    public void shouldReturnAnExperiencePointObject(){
        ExperiencePoint experiencePoint = new ExperiencePoint(0);
        Assertions.assertEquals(ExperiencePoint.class, experiencePoint.getClass());
    }
    @Test
    public void shouldReturnExperiencePointObjectWithValue1(){
        ExperiencePoint experiencePoint = new ExperiencePoint(1);
        Assertions.assertEquals(1, experiencePoint.getExperiencePoint());
    }

    @Test
    public void shouldAddTenPercentOdExperiencePoint(){
        ExperiencePoint experiencePoint = new ExperiencePoint(100);
        Assertions.assertEquals(110, experiencePoint.addTenPercentOfExperiencePoint().getExperiencePoint());
    }


    @Test
    public void shouldAddTenPercentOdExperiencePointWithoutDecimalValue(){
        ExperiencePoint experiencePoint = new ExperiencePoint(99);
        Assertions.assertEquals(108, experiencePoint.addTenPercentOfExperiencePoint().getExperiencePoint());
    }

    @Test
    public void shouldLevelUpReturnTrue(){
        ExperiencePoint experiencePoint = new ExperiencePoint(5);
        Assertions.assertEquals(true, experiencePoint.shouldLevelUp());
    }

    @Test
    public void shouldLevelUpReturnFalse(){
        ExperiencePoint experiencePoint = new ExperiencePoint(6);
        Assertions.assertEquals(false, experiencePoint.shouldLevelUp());
    }
}

