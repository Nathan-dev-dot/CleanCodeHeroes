package com.cleancodeheroes.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonSerialize
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