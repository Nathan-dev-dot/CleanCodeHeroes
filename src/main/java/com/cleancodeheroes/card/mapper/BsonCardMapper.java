package com.cleancodeheroes.card.mapper;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.hero.domain.Specialty;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

public class BsonCardMapper implements BsonMapper<Card> {
    private Document doc;

    public BsonCardMapper(Document doc) { this.doc = doc; }

    public Card toDomain () {
        BsonAdapter cardAdapter = BsonAdapter.of(this.doc);
        return Card.create (
                new CardProps(
                        CardId.of(cardAdapter.getObjectId("_id")),
                        cardAdapter.getString("name"),
                        cardAdapter.getInt("healthPoints"),
                        cardAdapter.getInt("experiencePoints"),
                        cardAdapter.getInt("power"),
                        cardAdapter.getInt("armour"),
                        Specialty.of(cardAdapter.getString("specialty")),
                        new Rarity(cardAdapter.getString("rarity")),
                        cardAdapter.getInt("level")
                )
        );
    }
}
