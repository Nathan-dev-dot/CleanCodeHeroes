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
                        IdUtils.fromStringToObjectId(card.getId().value())
                );
        this.updates = Updates.combine(
                Updates.set("level", card.getLevel().value()),
                Updates.set("healthPoints", card.getHealthPoints().value()),
                Updates.set("experiencePoints", card.getExperiencePoints().getExperiencePoint()),
                Updates.set("power", card.getPower().value()),
                Updates.set("armour", card.getArmour().value())
        );
    }
}
