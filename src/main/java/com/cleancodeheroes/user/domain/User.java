package com.cleancodeheroes.user.domain;

import com.cleancodeheroes.card.domain.CardId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Objects;

@JsonSerialize
public final class User {

    private final UserId userId;
    private final String username;
    private Token token;
    private Deck deck;

    public User(UserProps userProps){
        this.userId = userProps.userId;
        this.username = userProps.username;
        this.token = userProps.token;
        this.deck = userProps.deck;
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

    public void retrieveTokenByPackType(PackType packType){
        this.token = token.minus(packType);
    }

    public void updateDeck(ArrayList<CardId> cards) {
        cards.forEach(cardId -> {
            this.deck = this.deck.addCard(cardId);
        });
    }


    public void hasMinimalNumberOfToken(PackType packType){
        if(packType == PackType.Silver && this.token.value() < 1){
            throw new RuntimeException();
        }else if (packType == PackType.Diamond && this.token.value() < 2){
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getToken(), user.getToken()) && Objects.equals(getDeck(), user.getDeck());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUsername(), getToken(), getDeck());
    }
}
