package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardProps;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BattleResultTest {

    @Test
    public void shouldBattleResult(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultFistConstructor = new BattleResult(winner, loser);

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );
        Assertions.assertEquals(battleResultOfConstructor.getClass(), BattleResult.class);
        Assertions.assertEquals(battleResultFistConstructor.getClass(), BattleResult.class);
    }

    @Test
    public void shouldReturnWinnerCardId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getWinnerCardId(), winner.getId());
    }

    @Test
    public void shouldReturnLoserCardId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getLoserCardId(), loser.getId());
    }

    @Test
    public void shouldReturnWinnerHeroId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getWinnerHeroId(), winner.getParentHeroId());
    }

    @Test
    public void shouldReturnWinnerUserId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getWinnerUserId(), winner.getUserId());
    }

    @Test
    public void shouldReturnLoserHeroId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getLoserHeroId(), loser.getParentHeroId());
    }

    @Test
    public void shouldReturnLoserUserId(){
        Card winner = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card loser = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        BattleResult battleResultOfConstructor = BattleResult.of(
                winner.getId().value(),
                loser.getId().value(),
                winner.getParentHeroId().value(),
                winner.getUserId().value(),
                loser.getParentHeroId().value(),
                loser.getUserId().value()
        );

        Assertions.assertEquals(battleResultOfConstructor.getLoserUserId(), loser.getUserId());
    }
}
