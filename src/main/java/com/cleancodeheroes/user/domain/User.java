package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;

import java.util.ArrayList;
import java.util.Objects;

public final class User {

    private final UserId userId;
    private final String username;
    private Token token;
    private Deck deck;
    private Victories victories;

    public User(UserProps userProps){
        this.userId = userProps.userId;
        this.username = userProps.username;
        this.token = userProps.token;
        this.deck = userProps.deck;
        this.victories = userProps.victories;
    }

    public String getUsername() {
        return username;
    }

    public Token getToken() {
        return token;
    }

    public Deck getDeck() {
        return deck;
    }

    public UserId getUserId() {
        return userId;
    }

    public Victories getVictories() {
        return victories;
    }

    public void removeTokenByPackType(PackType packType) throws ArithmeticException {
        this.token = token.minus(packType);
    }

    public void addToken () {
        this.token = this.token.plusOneToken();
    }

    public void updateDeck(ArrayList<CardId> cards) {
        cards.forEach(cardId -> {
            this.deck = this.deck.addCard(cardId);
        });
    }

    public void hasMinimalNumberOfToken(PackType packType) throws RuntimeException {
        if (!this.token.hasMinimalNumberOfTokensForPackType(packType))
            throw new RuntimeException();
    }

    public void addVictory () {
        this.victories = this.victories.addOne();
    }

    public boolean shouldReceiveNewToken () {
        return this.victories.value() % 5 == 0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserId(), user.getUserId())
                && Objects.equals(getUsername(), user.getUsername())
                && Objects.equals(getToken(), user.getToken())
                && Objects.equals(getDeck(), user.getDeck())
                && Objects.equals(getVictories(), user.getVictories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getToken(), getDeck(), getVictories());
    }
}
