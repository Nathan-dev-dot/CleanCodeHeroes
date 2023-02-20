package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExperiencePointTest {
    @Test
    public void shouldReturnAnExperiencePointObject(){
        ExperiencePoint experiencePoint = ExperiencePoint.of(0);
        Assertions.assertEquals(ExperiencePoint.class, experiencePoint.getClass());
    }

    @Test
    public void shouldThrowIfExperiencePointIsNegative () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExperiencePoint.of(-1));
    }
    @Test
    public void shouldReturnExperiencePointObjectWithValue1(){
        ExperiencePoint experiencePoint = ExperiencePoint.of(1);
        Integer newExperiencePoint = experiencePoint.getExperiencePoint();
        Assertions.assertEquals(1, newExperiencePoint);
    }

    @Test
    public void shouldLevelUpReturnTrue(){
        ExperiencePoint experiencePoint = ExperiencePoint.of(5);
        boolean shouldLevelUp = experiencePoint.shouldLevelUp();
        Assertions.assertEquals(true, shouldLevelUp);
    }

    @Test
    public void shouldLevelUpReturnFalse(){
        ExperiencePoint experiencePoint = ExperiencePoint.of(6);
        boolean shouldLevelUp = experiencePoint.shouldLevelUp();
        Assertions.assertEquals(false, shouldLevelUp);
    }
}

