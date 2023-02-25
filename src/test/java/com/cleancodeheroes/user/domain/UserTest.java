package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void shouldCreateDefaultUser () {
        UserProps userProps = new UserProps("Test");
        User user = new User(userProps);
        Assertions.assertTrue(ObjectId.isValid(user.getUserId().value()));
        Assertions.assertEquals("Test", user.getUsername());
        Assertions.assertEquals(4, user.getToken().value());
        Assertions.assertEquals(new ArrayList<String>(), user.getDeck().getCards());
        Assertions.assertEquals(0, user.getVictories().value());
    }

    @Test
    public void shouldUpdateUserDeck () {
        CardId cardId = new CardId();
        ArrayList<CardId> cards = new ArrayList<>();
        cards.add(cardId);
        User user = new User(new UserProps("Test"));
        user.updateDeck(cards);
        Assertions.assertEquals(cards.size(), user.getDeck().size());
    }

    @Test
    public void shouldRemoveTokensForSilverPack () {
        User user = new User(new UserProps("Test"));
        PackCharacteristics packCharacteristics = PackCharacteristics.Silver();
        int expected = user.getToken().value() - packCharacteristics.getRequiredTokens();
        user.removeTokenByPackType(PackType.Silver);
        Assertions.assertEquals(expected, user.getToken().value());
    }

    @Test
    public void shouldRemoveTokensForDiamondPack () {
        User user = new User(new UserProps("Test"));
        PackCharacteristics packCharacteristics = PackCharacteristics.Diamond();
        int expected = user.getToken().value() - packCharacteristics.getRequiredTokens();
        user.removeTokenByPackType(PackType.Diamond);
        Assertions.assertEquals(expected, user.getToken().value());
    }

    @Test
    public void shouldThrowIfNotEnoughTokenForSilverPack () {
        PackCharacteristics packCharacteristics = PackCharacteristics.Silver();
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                Token.of(packCharacteristics.getRequiredTokens() - 1).value(),
                new Deck().getCards(),
                new Victories().value()
        ));
        Assertions.assertThrows(ArithmeticException.class, () -> user.removeTokenByPackType(PackType.Silver));
    }

    @Test
    public void shouldThrowIfNotEnoughTokenForDiamondPack () {
        PackCharacteristics packCharacteristics = PackCharacteristics.Diamond();
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                Token.of(packCharacteristics.getRequiredTokens() - 1).value(),
                new Deck().getCards(),
                new Victories().value()
        ));
        Assertions.assertThrows(ArithmeticException.class, () -> user.removeTokenByPackType(PackType.Diamond));
    }

    @Test
    public void shouldHaveMinimalNumberOfToken () {
        User user = new User(new UserProps("Test"));
        Assertions.assertDoesNotThrow(() -> user.hasMinimalNumberOfToken(PackType.Silver));
        Assertions.assertDoesNotThrow(() -> user.hasMinimalNumberOfToken(PackType.Diamond));
    }

    @Test
    public void shouldNotHaveMinimalNumberOfTokenForSilver () {
        PackCharacteristics packCharacteristics = PackCharacteristics.Silver();
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                Token.of(packCharacteristics.getRequiredTokens() - 1).value(),
                new Deck().getCards(),
                new Victories().value()
        ));
        Assertions.assertThrows(RuntimeException.class, () -> user.hasMinimalNumberOfToken(PackType.Silver));
    }

    @Test
    public void shouldNotHaveMinimalNumberOfTokenForDiamond () {
        PackCharacteristics packCharacteristics = PackCharacteristics.Diamond();
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                Token.of(packCharacteristics.getRequiredTokens() - 1).value(),
                new Deck().getCards(),
                new Victories().value()
        ));
        Assertions.assertThrows(RuntimeException.class, () -> user.hasMinimalNumberOfToken(PackType.Diamond));
    }

    @Test
    public void shouldAddToken () {
        User user = new User(new UserProps("Test"));
        int tokensBeforeUpdate = user.getToken().value();
        user.addToken();
        Assertions.assertEquals(tokensBeforeUpdate + 1, user.getToken().value());
    }

    @Test
    public void shouldAddVictory () {
        User user = new User(new UserProps("Test"));
        int victoriesBeforeUpdate = user.getVictories().value();
        user.addVictory();
        Assertions.assertEquals(victoriesBeforeUpdate + 1, user.getVictories().value());
    }

    @Test
    public void shouldReceiveNewToken () {
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                0,
                new ArrayList<String>(),
                5
        ));
        Assertions.assertTrue(user.shouldReceiveNewToken());
    }

    @Test
    public void shouldNotReceiveNewTokenAtInit () {
        User user = new User(new UserProps("Test"));
        Assertions.assertFalse(user.shouldReceiveNewToken());
    }

    @Test
    public void shouldNotReceiveNewToken () {
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                0,
                new ArrayList<String>(),
                4
        ));
        Assertions.assertFalse(user.shouldReceiveNewToken());
    }
}
