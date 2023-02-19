package com.cleancodeheroes.card.mapper;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

public class BsonCardMapper implements BsonMapper<Card> {
    private Document doc;

    public BsonCardMapper(Document doc) { this.doc = doc; }

    public Card toDomain () throws IllegalArgumentException {
        BsonAdapter cardAdapter = BsonAdapter.of(this.doc);
        return new Card (
                new CardProps(
                        cardAdapter.getObjectIdAsString("_id"),
                        cardAdapter.getString("heroId"),
                        cardAdapter.getString("name"),
                        cardAdapter.getInt("healthPoints"),
                        cardAdapter.getInt("experiencePoints"),
                        cardAdapter.getInt("power"),
                        cardAdapter.getInt("armour"),
                        cardAdapter.getString("specialty"),
                        cardAdapter.getString("rarity"),
                        cardAdapter.getInt("level"),
                        cardAdapter.getString("userId")
                )
        );
    }
}
