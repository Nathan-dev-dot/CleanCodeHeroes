package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.user.domain.User;
import org.bson.types.ObjectId;

import java.util.List;

public class NoSQLUserPersistenceDTO {
    public final String userId;
    public final String username;
    public final int token;
    public final List<String> deck;

    public NoSQLUserPersistenceDTO(User user) {
        this.userId = new ObjectId().toString();
        this.username = user.getUsername();
        this.token = user.getToken().getNumberOfToken();
        this.deck = user.getDeck().getCards();
    }
}
