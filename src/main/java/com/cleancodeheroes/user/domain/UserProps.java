package com.cleancodeheroes.user.domain;

public final class UserProps {
    UserId userId;
    String username;
    Token token;
    Deck deck;

    public UserProps(UserId userId, String username, Token token, Deck deck) {
        this.userId = userId;
        this.username = username;
        this.token = token;
        this.deck = deck;
    }
}
