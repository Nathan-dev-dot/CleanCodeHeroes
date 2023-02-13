package com.cleancodeheroes.user.adapter.out;

import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.application.port.out.FindUserPort;
import com.cleancodeheroes.user.application.port.out.UpdateUserPort;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.mapper.BsonUserMapper;
import com.cleancodeheroes.utils.BsonFilter;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.MongoCollection;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.Objects;

public final class NoSQLUserPersistence implements FindUserPort, CreateUserPort, UpdateUserPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("users");
    @Override
    public UserId save(User user) {
        final NoSQLUserPersistenceDTO newUser = new NoSQLUserPersistenceDTO(user);
        final Document userDocument = DocumentUtils.documentFromObject(newUser);
        final BsonValue insertedId = registry.insertOne(userDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return UserId.of(insertedIdStr);
    }

    @Override
    public User load(UserId userId) throws UserNotFoundException{
        var res = registry.find(
                new BsonFilter(userId.value()).filter
        );

        if (DocumentUtils.sizeof(res) == 0) throw new UserNotFoundException();
        return res.map(doc -> new BsonUserMapper(doc).toDomain()).first();
    }

    @Override
    public UserId update(User user) {
        registry.findOneAndDelete(new BsonFilter(user.getUserId().value()).filter);
        return this.save(user);
    }
}
