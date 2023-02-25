package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardProps;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BattleTest {

    @Test
    public void shouldCreateBattle() {
        Card attacker = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        100,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card defender = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        50,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );
        
        
        Battle battle = Battle.of(attacker, defender);
        Assertions.assertEquals(battle.getClass(), Battle.class);
    }

    @Test
    public void shouldReturnWinnerAttackerCard() {
        Card attacker = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card defender = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        101,
                        151,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Battle battle = Battle.of(attacker, defender);
        Assertions.assertEquals(battle.getWinner(), attacker);
    }

    @Test
    public void shouldReturnLoserAttackerCard() {
        Card attacker = new Card(
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

        Card defender = new Card(
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

        Battle battle = Battle.of(attacker, defender);
        Assertions.assertEquals(battle.getLoser(), attacker);
    }

    @Test
    public void shouldReturnLoserDefenderCard() {
        Card attacker = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Card defender = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "Sarah",
                        50,
                        1,
                        101,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );

        Battle battle = Battle.of(attacker, defender);
        Assertions.assertEquals(battle.getLoser(), defender);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        Card attacker = new Card(
                new CardProps(
                        new ObjectId().toString(),
                        new ObjectId().toString(),
                        "nathan",
                        100,
                        1,
                        150,
                        100,
                        "Assassin",
                        "Common",
                        1,
                        new ObjectId().toString()
                )
        );


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Battle.of(attacker, attacker);
        });
    }
}
