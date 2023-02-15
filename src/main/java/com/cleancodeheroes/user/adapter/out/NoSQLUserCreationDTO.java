package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.user.domain.User;

import java.util.List;

public class NoSQLUserCreationDTO {
    public final String username;
    public final int token;
    public final List<String> deck;

    public NoSQLUserCreationDTO(User user) {
        this.username = user.getUsername();
        this.token = user.getToken().getNumberOfToken();
        this.deck = user.getDeck().getCards();
    }
}
