package com.cleancodeheroes.battle.adapter.out;

import com.cleancodeheroes.battle.application.port.out.FindBattleByHeroIdPort;
import com.cleancodeheroes.battle.application.port.out.FindBattleByUserIdPort;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.battle.mapper.BsonBattleResultMapper;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.utils.DocumentUtils;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

public class NoSQLBattlePersistence implements FindBattleByHeroIdPort, FindBattleByUserIdPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("battles");

    @Override
    public ArrayList<BattleResult> loadBattleByHeroId(HeroId heroId) throws NoBattleFoundException {
        //TODO filter hero
        FindIterable<Document> res = registry.find(Filters.eq(
                "parentHeroId",
                heroId.value()
        ));
        if (DocumentUtils.sizeof(res) == 0) throw new NoBattleFoundException();
        return res
                .map(doc -> new BsonBattleResultMapper(doc).toDomain())
                .into(new ArrayList<>());
    }

    @Override
    public ArrayList<BattleResult> loadBattleByUserId(UserId userId) throws NoBattleFoundException {
        //TODO filter user
        FindIterable<Document> res = registry.find(Filters.eq(
                "userId",
                userId.value()
        ));
        if (DocumentUtils.sizeof(res) == 0) throw new NoBattleFoundException();
        return res
                .map(doc -> new BsonBattleResultMapper(doc).toDomain())
                .into(new ArrayList<>());
    }
}
