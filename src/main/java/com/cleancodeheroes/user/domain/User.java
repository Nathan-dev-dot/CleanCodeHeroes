package com.cleancodeheroes.user.domain;

public final class User {

    private final UserId userId;
    private final String username;
    private final Token token;
    private final Deck deck;

    private User(UserProps userProps){
        this.userId = userProps.userId;
        this.username = userProps.username;
        this.token = userProps.token;
        this.deck = userProps.deck;
    }

    public static User of(UserProps userProps){
        return new User(userProps);
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
}
