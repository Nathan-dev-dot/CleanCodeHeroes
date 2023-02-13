package com.cleancodeheroes.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackTest {
    @Test
    public void shouldReturnDiamondPackTypeEnum () {
        var diamondPackType = Pack.of("Diamond");
        Assertions.assertEquals(PackType.Diamond, diamondPackType.getPackType());
    }
    @Test
    public void shouldReturnSilverPackTypeEnum () {
        var silverPackType = Pack.of("Silver");
        Assertions.assertEquals(PackType.Silver, silverPackType.getPackType());
    }

    @Test
    public void shouldThrowForIllegalArgument () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var fakePackType = Pack.of("Fake");
        });
    }
}
