package com.cleancodeheroes.user.mapper;

import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.user.domain.*;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

import java.util.ArrayList;

public final class BsonUserMapper implements BsonMapper<User> {

    private final Document doc;

    public BsonUserMapper (Document doc) { this.doc = doc; }

    public User toDomain() {
        BsonAdapter heroAdapter = BsonAdapter.of(this.doc);
        final ArrayList<String> cards = heroAdapter.getStringObjectIdsArray("deck");
        UserProps userProps = new UserProps(
                UserId.of(heroAdapter.getObjectId("_id")),
                heroAdapter.getString("username"),
                Token.of(heroAdapter.getInt("token")),
                new Deck(cards)
        );
        return new User(userProps);
    }
}
