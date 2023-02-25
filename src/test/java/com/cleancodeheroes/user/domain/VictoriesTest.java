package com.cleancodeheroes.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VictoriesTest {
    @Test
    public void shouldCreateVictory () {
        var victories = new Victories();
        Assertions.assertInstanceOf(Victories.class, victories);
        Assertions.assertEquals(0, victories.value());
    }

    @Test
    public void shouldCreateVictoryWithCount () {
        var victories = Victories.of(1);
        Assertions.assertInstanceOf(Victories.class, victories);
        Assertions.assertEquals(1, victories.value());
    }

    @Test
    public void shouldThrowIfNegativeVictories () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Victories.of(-1));
    }

    @Test
    public void shouldAddOneVictory () {
        Victories victories = new Victories();
        Victories newVictories = victories.addOne();
        Assertions.assertEquals(victories.value() + 1, newVictories.value());
    }
}

