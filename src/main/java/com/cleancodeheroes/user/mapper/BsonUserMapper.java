package com.cleancodeheroes.user.mapper;

import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.user.domain.*;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;
import org.json.JSONObject;

public final class BsonUserMapper implements BsonMapper<User> {

    private final Document doc;

    public BsonUserMapper (Document doc) { this.doc = doc; }

    public User toDomain() {
        BsonAdapter heroAdapter = BsonAdapter.of(this.doc);
        UserProps userProps = new UserProps(
                UserId.of(heroAdapter.getObjectId("_id")),
                heroAdapter.getString("username"),
                new Token(4),//todo
                new Deck()
        );
        return new User(userProps);
    }
}
