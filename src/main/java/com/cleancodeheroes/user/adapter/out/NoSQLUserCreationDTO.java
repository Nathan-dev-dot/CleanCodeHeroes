package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.user.domain.User;

import java.util.List;

public class NoSQLUserCreationDTO {
    public final String username;
    public final int token;
    public final List<String> deck;
    public final int victories;

    public NoSQLUserCreationDTO(User user) {
        this.username = user.getUsername();
        this.token = user.getToken().value();
        this.deck = user.getDeck().getCards();
        this.victories = user.getVictories().value();
    }
}
