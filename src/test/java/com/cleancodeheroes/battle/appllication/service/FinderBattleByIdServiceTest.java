package com.cleancodeheroes.battle.appllication.service;

import com.cleancodeheroes.battle.adapter.out.BattleNotFoundException;
import com.cleancodeheroes.battle.application.port.in.FindBattleByIdQuery;
import com.cleancodeheroes.battle.application.port.out.FindBattleByIdPort;
import com.cleancodeheroes.battle.application.service.FinderBattleByIdService;
import com.cleancodeheroes.battle.domain.Battle;
import com.cleancodeheroes.battle.domain.BattleId;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardProps;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinderBattleByIdServiceTest {

    @InjectMocks
    FinderBattleByIdService finderBattleByIdService;

    @Mock
    FindBattleByIdPort findBattleByIdPort;

    @Test
    public void shouldReturnAnBattleResult(){
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
        try {
            when(this.findBattleByIdPort.loadBattleById(any(BattleId.class))).thenReturn(battleResultFistConstructor);
            FindBattleByIdQuery findBattleByIdQuery = new FindBattleByIdQuery(new ObjectId().toString());
            BattleResult battleResult = this.finderBattleByIdService.handle(findBattleByIdQuery);
            Assertions.assertEquals(battleResult.getClass(), BattleResult.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldThrowAnIllegalArgumentException(){
        FindBattleByIdQuery findBattleByIdQuery = new FindBattleByIdQuery("wrong id");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.finderBattleByIdService.handle(findBattleByIdQuery);
        });
    }
}
