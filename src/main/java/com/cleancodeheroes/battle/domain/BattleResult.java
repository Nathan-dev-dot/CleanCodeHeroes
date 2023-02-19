package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.user.domain.UserId;

public class BattleResult {
    private final CardId winnerCardId;
    private final CardId loserCardId;
    private final HeroId winnerHeroId;
    private final UserId winnerUserId;
    private final HeroId loserHeroId;
    private final UserId loserUserId;

    private BattleResult(
            CardId winnerCardId,
            CardId loserCardId,
            HeroId winnerHeroId,
            UserId winnerUserId,
            HeroId loserHeroId,
            UserId loserUserId
    ) {
        this.winnerCardId = winnerCardId;
        this.loserCardId = loserCardId;
        this.winnerHeroId = winnerHeroId;
        this.winnerUserId = winnerUserId;
        this.loserHeroId = loserHeroId;
        this.loserUserId = loserUserId;
    }

    public static BattleResult of( String winnerCardId,
                            String loserCardId,
                            String winnerHeroId,
                            String winnerUserId,
                            String loserHeroId,
                            String loserUserId){
        return new BattleResult(
                CardId.of(winnerCardId),
                CardId.of(loserCardId),
                HeroId.of(winnerHeroId),
                UserId.of(winnerUserId),
                HeroId.of(loserHeroId),
                UserId.of(loserUserId)
        );
    }

    public CardId getWinnerCardId() {
        return winnerCardId;
    }

    public CardId getLoserCardId() {
        return loserCardId;
    }

    public HeroId getWinnerHeroId() {
        return winnerHeroId;
    }

    public UserId getWinnerUserId() {
        return winnerUserId;
    }

    public HeroId getLoserHeroId() {
        return loserHeroId;
    }

    public UserId getLoserUserId() {
        return loserUserId;
    }
}
