package com.cleancodeheroes.user.mapper;
import com.cleancodeheroes.shared.BsonMapper;
import com.cleancodeheroes.user.domain.*;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;
import org.json.JSONObject;

public class BsonUserMapper implements BsonMapper<User> {

    private Document doc;

    public BsonUserMapper (Document doc) { this.doc = doc; }
    @Override
    public User toDomain() {
        JSONObject jsonUser = new JSONObject(this.doc);
        UserProps userProps = new UserProps(
                UserId.of(jsonUser.getJSONObject("userId").getString("userId")),
                jsonUser.getString("username"),
                Token.of(jsonUser.getJSONObject("token").getInt("numberOfToken")),
                new Deck()
        );
        return User.of(userProps);
    }
}
