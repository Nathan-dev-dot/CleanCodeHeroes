package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DeckTest {
    @Test
    public void shouldCreateEmptyDeck () {
        var deck = Deck.newEmptyDeck() ;
        Assertions.assertInstanceOf(Deck.class, deck);
        Assertions.assertEquals(0, deck.getCards().size());
    }

    @Test
    public void shouldCreateDeckWithCards () {
        String cardId = "demoCardId";
        ArrayList<String> cards = new ArrayList<String>();
        cards.add(cardId);
        Deck deck = new Deck(cards);
        Assertions.assertEquals(1, deck.getCards().size());
    }

    @Test
    public void shouldAddACardFromCardId () {
        CardId cardId = CardId.of(new ObjectId());
        Deck deck = Deck.newEmptyDeck();
        Deck newDeck = deck.addCard(cardId);
        Assertions.assertEquals(1, newDeck.getCards().size());
        Assertions.assertEquals(cardId.value(), newDeck.getCards().get(0));
    }
}
