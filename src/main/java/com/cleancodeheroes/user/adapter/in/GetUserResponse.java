package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.user.domain.Deck;
import com.cleancodeheroes.user.domain.Token;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public final class GetUserResponse {
    private Deck deck;
    private String id;
    private int token;
    private String username;

    private GetUserResponse(Deck deck, UserId userId, Token token, String username) {
        this.id = userId.value();
        this.token = token.value();
        this.username = username;
        this.deck = deck;
    }

    public static GetUserResponse of(User user) {
        return new GetUserResponse(user.getDeck(), user.getUserId(), user.getToken(), user.getUsername());
    }

    public Deck getDeck() {
        return deck;
    }

    public String getId() {
        return id;
    }

    public int getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }
}
