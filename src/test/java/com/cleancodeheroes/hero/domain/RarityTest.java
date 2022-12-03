package com.cleancodeheroes.hero.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RarityTest {

    @Test
    public void shouldCreateRarity () {
        var commonRarity = new Rarity("Common");
        Assertions.assertEquals(Rarities.Common, commonRarity.rarity);
    }

    @Test
    public void shouldThrowErrorForIllegalRarity () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var fakeRarity = new Rarity("Fake");
        });
    }

    @Test
    public void shouldReturnRarityAsString () {
        var commonRarity = new Rarity("Common");
        var commonRarityAsString = commonRarity.toString();
        Assertions.assertEquals("Common", commonRarityAsString);
    }
}
