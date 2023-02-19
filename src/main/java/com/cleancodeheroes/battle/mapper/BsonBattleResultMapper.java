package com.cleancodeheroes.battle.mapper;

import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

public class BsonBattleResultMapper implements BsonMapper<BattleResult> {
    private Document doc;

    public BsonBattleResultMapper(Document doc) { this.doc = doc; }

    @Override
    public BattleResult toDomain() {
        BsonAdapter cardAdapter = BsonAdapter.of(this.doc);
        return BattleResult.of (
                cardAdapter.getString("winnerCardId"),
                cardAdapter.getString("loserCardId"),
                cardAdapter.getString("winnerHeroId"),
                cardAdapter.getString("winnerUserId"),
                cardAdapter.getString("loserHeroId"),
                cardAdapter.getString("loserUserId")
        );
    }
}
