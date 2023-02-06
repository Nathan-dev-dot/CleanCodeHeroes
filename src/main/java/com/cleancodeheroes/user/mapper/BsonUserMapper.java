package com.cleancodeheroes.user.mapper;

import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.user.domain.*;
import org.bson.Document;
import org.json.JSONObject;

public final class BsonUserMapper implements BsonMapper<User> {

    private Document doc;

    public BsonUserMapper (Document doc) { this.doc = doc; }

    @Override
    public User toDomain() {
        JSONObject jsonUser = new JSONObject(this.doc);
        UserProps userProps = new UserProps(
                UserId.of(jsonUser.getJSONObject("userId").getString("userId")),
                jsonUser.getString("username"),
                new Token(jsonUser.getJSONObject("token").getInt("numberOfToken")),
                new Deck()
        );
        return new User(userProps);
    }
}
