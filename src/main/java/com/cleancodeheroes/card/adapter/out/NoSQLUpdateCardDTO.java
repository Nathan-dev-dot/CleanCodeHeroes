package com.cleancodeheroes.card.adapter.out;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;


public class NoSQLUpdateCardDTO {

    public final Bson updates;

    public final Document query;

    public NoSQLUpdateCardDTO(Card card) {
        this.query = new Document()
                .append(
                        "_id",
                        IdUtils.fromStringToObjectId(card.Id().value())
                );
        this.updates = Updates.combine(
                Updates.set("level", card.Level()),
                Updates.set("healthPoints", card.HealthPoints()),
                Updates.set("experiencePoints", card.ExperiencePoints()),
                Updates.set("power", card.Power()),
                Updates.set("armour", card.Armour())
        );
    }
}
