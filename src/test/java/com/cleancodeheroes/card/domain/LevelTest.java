package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevelTest {
    @Test
    public void shouldReturnAnLevelObject(){
        Level level = new Level(1);
        Assertions.assertEquals(Level.class, level.getClass());
    }
    @Test
    public void shouldReturnLevelObjectWithValue1(){
        Level level = new Level(1);
        Integer newLevelInteger = level.getLevel();
        Assertions.assertEquals(1, newLevelInteger);
    }

    @Test
    public void shouldAddOneLevel(){
        Level level = new Level(1);
        Integer newLevelInteger = level.addOneLevel().getLevel();
        Assertions.assertEquals(2, newLevelInteger);
    }
}
