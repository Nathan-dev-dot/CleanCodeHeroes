package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.shared.NoSQLRepository;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.application.port.out.FindUserPort;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.mapper.BsonUserMapper;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.BsonValue;
import org.bson.Document;

public class NoSQLUserPersistence implements FindUserPort, CreateUserPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getInstance().getDatabase().getCollection("users");
    @Override
    public UserId save(User user) {
        final Document heroDocument = DocumentUtils.documentFromObject(user);
        final BsonValue insertedId = registry.insertOne(heroDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return UserId.of(insertedIdStr);
    }

    @Override
    public User load(UserId userId) {
        var res = registry.find(Filters.eq(
                "_id",
                IdUtils.fromStringToObjectId(userId.getId())
        ));
        //if (DocumentUtils.sizeof(res) == 0) throw new HeroNotFoundException();
        User user = res.map(doc -> new BsonUserMapper(doc).toDomain()).first();
        return user;
    }
}
