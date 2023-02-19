package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;

import java.util.ArrayList;

public final class Deck {
    private final ArrayList<String> cards;

    public Deck(ArrayList<String> cards) {
        this.cards = cards;
    }

    public Deck () {
        this.cards = new ArrayList<>();
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public int size () { return this.cards.size(); }

    public Deck addCard(CardId cardId) {
        ArrayList<String> newDeck = this.cards;
        newDeck.add(cardId.value());
        return new Deck(newDeck);
    }
}
