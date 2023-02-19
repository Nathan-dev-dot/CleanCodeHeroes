package com.cleancodeheroes.battle.adapter.out;

import com.cleancodeheroes.battle.domain.BattleResult;

public class NoSQLBattleCreationDTO {
    public final String winnerCardId;
    public final String winnerHeroId;
    public final String winnerUserId;
    public final String loserCardId;
    public final String loserHeroId;
    public final String loserUserId;

    public NoSQLBattleCreationDTO (BattleResult battleResult) {
        this.winnerCardId = battleResult.getWinnerCardId().value();
        this.winnerHeroId = battleResult.getWinnerHeroId().value();
        this.winnerUserId = battleResult.getWinnerUserId().value();
        this.loserCardId = battleResult.getLoserCardId().value();
        this.loserHeroId = battleResult.getLoserHeroId().value();
        this.loserUserId = battleResult.getLoserUserId().value();
    }
}
