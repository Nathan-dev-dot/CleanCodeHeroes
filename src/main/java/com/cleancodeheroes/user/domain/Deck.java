package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public final class Deck {
    private final ArrayList<String> cards;

    public Deck(ArrayList<String> cards) {
        this.cards = cards;
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public Deck addCard(CardId cardId) {
        ArrayList<String> newDeck = this.cards;
        newDeck.add(cardId.value());
        return new Deck(newDeck);
    }
}
