package com.cleancodeheroes.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackTypeTest {
    @Test
    public void shouldReturnDiamondPackTypeEnum () {
        var diamondPackType = PackType.valueOf("Diamond");
        Assertions.assertEquals(PackType.Diamond, diamondPackType);
    }
    @Test
    public void shouldReturnSilverPackTypeEnum () {
        var silverPackType = PackType.valueOf("Silver");
        Assertions.assertEquals(PackType.Silver, silverPackType);
    }

    @Test
    public void shouldThrowForIllegalArgument () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var fakePackType = PackType.valueOf("Fake");
        });
    }
}
