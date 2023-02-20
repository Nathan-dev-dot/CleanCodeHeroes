package com.cleancodeheroes.user.domain;

import java.util.ArrayList;

public final class UserProps {
    public final UserId userId;
    public final String username;
    public final Token token;
    public final Deck deck;
    public final Victories victories;

    public UserProps(String userId, String username, int token, ArrayList<String> deck, int victories) {
        this.userId = UserId.of(userId);
        this.username = username;
        this.token = Token.of(token);
        this.deck = new Deck(deck);
        this.victories = Victories.of(victories);
    }

    public UserProps (String username) {
        this.userId = new UserId();
        this.username = username;
        this.token = new Token();
        this.deck = new Deck();
        this.victories = new Victories();
    }
}
