package com.cleancodeheroes.card.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LevelTest {
    @Test
    public void shouldReturnAnLevelObject(){
        Level level = Level.of(1);
        Assertions.assertEquals(Level.class, level.getClass());
    }

    @Test
    public void shouldThrowIfLevelInferiorToOne () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Level.of(0));
    }

    @Test
    public void shouldReturnLevelObjectWithValue1(){
        Level level = Level.of(1);
        Integer newLevelInteger = level.value();
        Assertions.assertEquals(1, newLevelInteger);
    }

    @Test
    public void shouldAddOneLevel(){
        Level level = Level.of(1);
        Integer newLevelInteger = level.addOneLevel().value();
        Assertions.assertEquals(2, newLevelInteger);
    }
}
