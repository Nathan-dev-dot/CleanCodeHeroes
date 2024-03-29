package com.cleancodeheroes.user.mapper;

import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserProps;
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
                heroAdapter.getObjectIdAsString("_id"),
                heroAdapter.getString("username"),
                heroAdapter.getInt("token"),
                cards,
                heroAdapter.getInt("victories")
        );
        return new User(userProps);
    }
}
