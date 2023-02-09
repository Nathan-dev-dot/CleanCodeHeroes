package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.user.domain.Deck;
import com.cleancodeheroes.user.domain.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class GetUserResponse {
    public final Deck deck;
    public final String id;
    public final int token;
    public final String username;

    public GetUserResponse(User user) {
        this.id = user.getUserId().value();
        this.token = user.getToken().value();
        this.username = user.getUsername();
        this.deck = user.getDeck();
    }
}
