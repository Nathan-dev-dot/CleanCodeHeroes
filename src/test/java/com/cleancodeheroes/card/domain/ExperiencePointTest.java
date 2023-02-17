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
        Integer newExperiencePoint = experiencePoint.getExperiencePoint();
        Assertions.assertEquals(1, newExperiencePoint);
    }

    @Test
    public void shouldAddTenPercentOdExperiencePoint(){
        ExperiencePoint experiencePoint = new ExperiencePoint(100);
        Integer newExperiencePoint = experiencePoint.increaseByFactor().getExperiencePoint();
        Assertions.assertEquals(110, newExperiencePoint);
    }


    @Test
    public void shouldAddTenPercentOdExperiencePointWithoutDecimalValue(){
        ExperiencePoint experiencePoint = new ExperiencePoint(99);
        Integer newExperiencePoint = experiencePoint.increaseByFactor().getExperiencePoint();
        Assertions.assertEquals(108, newExperiencePoint);
    }

    @Test
    public void shouldLevelUpReturnTrue(){
        ExperiencePoint experiencePoint = new ExperiencePoint(5);
        boolean shouldLevelUp = experiencePoint.shouldLevelUp();
        Assertions.assertEquals(true, shouldLevelUp);
    }

    @Test
    public void shouldLevelUpReturnFalse(){
        ExperiencePoint experiencePoint = new ExperiencePoint(6);
        boolean shouldLevelUp = experiencePoint.shouldLevelUp();
        Assertions.assertEquals(false, shouldLevelUp);
    }
}

