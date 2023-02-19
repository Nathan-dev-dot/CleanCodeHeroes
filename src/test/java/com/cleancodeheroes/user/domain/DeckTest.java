package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DeckTest {
    @Test
    public void shouldCreateEmptyDeck () {
        var deck = new Deck() ;
        Assertions.assertInstanceOf(Deck.class, deck);
        Assertions.assertEquals(0, deck.size());
    }

    @Test
    public void shouldCreateDeckWithCards () {
        String cardId = "demoCardId";
        ArrayList<String> cards = new ArrayList<String>();
        cards.add(cardId);
        Deck deck = new Deck(cards);
        Assertions.assertEquals(1, deck.size());
    }

    @Test
    public void shouldReturnDeckSizeForEmptyDeck () {
        Deck emptyDeck = new Deck();
        Assertions.assertEquals(0, emptyDeck.size());
    }

    @Test
    public void shouldReturnDeckSizeForNotEmptyDeck () {
        String cardId = new CardId().value();
        ArrayList<String> cards = new ArrayList<>();
        cards.add(cardId);
        Deck newDeck = new Deck(cards);
        Assertions.assertEquals(1, newDeck.size());
    }

    @Test
    public void shouldAddACardFromCardId () {
        CardId cardId = new CardId();
        Deck deck = new Deck();
        Assertions.assertEquals(0, deck.size());
        Deck newDeck = deck.addCard(cardId);
        Assertions.assertEquals(cardId.value(), newDeck.getCards().get(0));
    }
}
