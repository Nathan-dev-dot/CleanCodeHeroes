package com.cleancodeheroes.user.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokenTest {

    @Test
    public void shouldCreateTokenWithGivenNumber () {
        var token = Token.of(1);
        Assertions.assertInstanceOf(Token.class, token);
        Assertions.assertEquals(1, token.value());
    }

    @Test
    public void shouldThrowIfCreatingTokenWithNegativeValue () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Token.of(-1));
    }

    @Test
    public void shouldRemoveTokensFromSilverPack () {
        PackCharacteristics packCharacteristics = PackCharacteristics.of(PackType.Silver);
        int startToken = packCharacteristics.getRequiredTokens();
        Token token = Token.of(startToken);
        var updatedToken = token.minus(PackType.Silver);
        Assertions.assertEquals(0, updatedToken.value());
    }

    @Test
    public void shouldRemoveTokensFromDiamondPack () {
        var packCharacteristics = PackCharacteristics.of(PackType.Diamond);
        int startToken = packCharacteristics.getRequiredTokens();
        Token token = Token.of(startToken);
        var updatedToken = token.minus(PackType.Diamond);
        Assertions.assertEquals(0,updatedToken.value());
    }

    @Test
    public void shouldThrowIfNotEnoughTokensToRemove () {
        Token token = Token.of(1);
        Assertions.assertThrows(ArithmeticException.class, () -> token.minus(PackType.Diamond));
    }

    @Test
    public void shouldAddOneToken () {
        Token token = Token.of(0);
        var updatedToken = token.plusOneToken();
        Assertions.assertEquals(1, updatedToken.value());
    }
}
