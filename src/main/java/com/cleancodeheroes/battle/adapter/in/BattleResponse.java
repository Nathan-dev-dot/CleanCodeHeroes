package com.cleancodeheroes.battle.adapter.in;

import com.cleancodeheroes.battle.domain.BattleResult;

public class BattleResponse {
    public final String winnerCardId;
    public final String loserCardId;
    public final String winnerHeroId;
    public final String winnerUserId;
    public final String loserHeroId;
    public final String loserUserId;

    private BattleResponse(
            String winnerCardId,
            String loserCardId,
            String winnerHeroId,
            String winnerUserId,
            String loserHeroId,
            String loserUserId
    ) {
        this.winnerCardId = winnerCardId;
        this.loserCardId = loserCardId;
        this.winnerHeroId = winnerHeroId;
        this.winnerUserId = winnerUserId;
        this.loserHeroId = loserHeroId;
        this.loserUserId = loserUserId;
    }

    public static BattleResponse of(BattleResult battleResult){
        return new BattleResponse(
                battleResult.winnerCardId.value(),
                battleResult.loserCardId.value(),
                battleResult.winnerHeroId.value(),
                battleResult.winnerUserId.value(),
                battleResult.loserHeroId.value(),
                battleResult.loserUserId.value()
        );
    }
}
