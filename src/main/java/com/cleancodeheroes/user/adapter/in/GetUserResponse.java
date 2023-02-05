package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.hero.adapter.in.GetHeroResponse;
import com.cleancodeheroes.user.domain.Deck;
import com.cleancodeheroes.user.domain.Token;
import com.cleancodeheroes.user.domain.UserId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class GetUserResponse {
    private Deck deck;
    private String id;
    private int token;
    private String username;

    public GetUserResponse(Deck deck, UserId userId, Token token, String username) {
        this.id = userId.getId();
        this.token = token.value();
        this.username = username;
        this.deck = deck;
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
