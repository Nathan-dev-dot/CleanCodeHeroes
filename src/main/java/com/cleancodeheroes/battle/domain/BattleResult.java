package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.user.domain.UserId;

public class BattleResult {
    public final CardId winnerCardId;
    public final CardId loserCardId;
    public final HeroId winnerHeroId;
    public final UserId winnerUserId;
    public final HeroId loserHeroId;
    public final UserId loserUserId;

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

    public BattleResult (Card winner, Card loser) {
        this.winnerCardId = winner.getId();
        this.winnerHeroId = winner.getParentHeroId();
        this.winnerUserId = winner.getUserId();
        this.loserCardId = loser.getId();
        this.loserHeroId = loser.getParentHeroId();
        this.loserUserId = loser.getUserId();
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
