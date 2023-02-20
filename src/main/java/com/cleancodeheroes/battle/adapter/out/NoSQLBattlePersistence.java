package com.cleancodeheroes.battle.adapter.out;

import com.cleancodeheroes.battle.application.port.out.CreateBattlePort;
import com.cleancodeheroes.battle.application.port.out.FindBattleByHeroIdPort;
import com.cleancodeheroes.battle.application.port.out.FindBattleByIdPort;
import com.cleancodeheroes.battle.application.port.out.FindBattleByUserIdPort;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.battle.mapper.BsonBattleResultMapper;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.utils.BsonFilter;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.ArrayList;

public class NoSQLBattlePersistence implements FindBattleByHeroIdPort, FindBattleByUserIdPort, CreateBattlePort, FindBattleByIdPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("battles");

    @Override
    public BattleId save(BattleResult battleResult) {
        final NoSQLBattleCreationDTO newBattle = new NoSQLBattleCreationDTO(battleResult);
        final Document battleDocument = DocumentUtils.documentFromObject(newBattle);
        final BsonValue insertedId = registry.insertOne(battleDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return BattleId.of(insertedIdStr);
    }

    @Override
    public ArrayList<BattleResult> loadBattleByHeroId(HeroId heroId) throws NoBattleFoundException {
        FindIterable<Document> res = registry.find(
                Filters.or(
                        new BsonFilter("winnerHeroId", heroId.value()).filter,
                        new BsonFilter("loserHeroId", heroId.value()).filter
                )
        );
        if (DocumentUtils.sizeof(res) == 0) throw new NoBattleFoundException();
        return res
                .map(doc -> new BsonBattleResultMapper(doc).toDomain())
                .into(new ArrayList<>());
    }

    @Override
    public ArrayList<BattleResult> loadBattleByUserId(UserId userId) throws NoBattleFoundException {
        FindIterable<Document> res = registry.find(
                Filters.or(
                        new BsonFilter("winnerUserId", userId.value()).filter,
                        new BsonFilter("loserUserId", userId.value()).filter
                )
        );
        if (DocumentUtils.sizeof(res) == 0) throw new NoBattleFoundException();
        return res
                .map(doc -> new BsonBattleResultMapper(doc).toDomain())
                .into(new ArrayList<>());
    }

    @Override
    public BattleResult loadBattleById(BattleId battleId) throws BattleNotFoundException {
        var res = registry.find(
                new BsonFilter(battleId.value()).filter
        );
        if (DocumentUtils.sizeof(res) == 0) throw new BattleNotFoundException();
        return res.map(doc -> new BsonBattleResultMapper(doc).toDomain()).first();
    }
}
