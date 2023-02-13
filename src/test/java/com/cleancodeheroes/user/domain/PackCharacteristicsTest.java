package com.cleancodeheroes.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PackCharacteristicsTest {
    @Test
    public void shouldReturnCharacteristicsForSilverPackType () {
        var pack = PackCharacteristics.Silver() ;
        Assertions.assertEquals(PackType.Silver, pack.getType());
        Assertions.assertEquals(3, pack.getNumberOfCards());
        Assertions.assertEquals(0.05, pack.getLegendaryDropPercentage());
        Assertions.assertEquals(0.2, pack.getRareDropPercentage());
        Assertions.assertEquals(0.75, pack.getCommonDropPercentage());
    }
    @Test
    public void shouldReturnCharacteristicsForDiamondPackType () {
        var pack = PackCharacteristics.Diamond() ;
        Assertions.assertEquals(PackType.Diamond, pack.getType());
        Assertions.assertEquals(5, pack.getNumberOfCards());
        Assertions.assertEquals(0.15, pack.getLegendaryDropPercentage());
        Assertions.assertEquals(0.35, pack.getRareDropPercentage());
        Assertions.assertEquals(0.5, pack.getCommonDropPercentage());
    }
}
