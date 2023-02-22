package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;

public class NoSQLUserUpdateDTO {
    public final Bson updates;

    public final Document query;

    public NoSQLUserUpdateDTO(User user) {
        this.query = new Document()
                .append(
                        "_id",
                        IdUtils.fromStringToObjectId(user.getUserId().value())
                );
        List<ObjectId> deckAsObjectIds = user
                .getDeck().getCards().stream().map(IdUtils::fromStringToObjectId).toList();
        this.updates = Updates.combine(
                Updates.set("token", user.getToken().value()),
                Updates.set("deck", deckAsObjectIds),
                Updates.set("victories", user.getVictories().value())
        );
    }
}
