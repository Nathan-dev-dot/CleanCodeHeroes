package com.cleancodeheroes.battle.application.service;

import com.cleancodeheroes.battle.adapter.out.NoSQLBattlePersistence;
import com.cleancodeheroes.battle.application.port.in.CreateBattleCommand;
import com.cleancodeheroes.battle.application.port.out.CreateBattlePort;
import com.cleancodeheroes.battle.application.service.BattleCreationService;
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
import org.mockito.junit.jupiter.MockitoSettings;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
public class BattleCreationServiceTest {

    @InjectMocks
    private BattleCreationService battleCreationService;

    @Mock
    CreateBattlePort createBattlePort;

    @Test
    public void shouldReturnABattleId(){
        BattleId battleId = BattleId.of(new ObjectId().toString());
        when(this.createBattlePort.save(any(BattleResult.class))).thenReturn(battleId);
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
        CreateBattleCommand createBattleCommand = new CreateBattleCommand(battle);
        BattleId newBattleId = this.battleCreationService.handle(createBattleCommand);
        Assertions.assertEquals(newBattleId.getClass(), BattleId.class);
        Assertions.assertEquals(newBattleId.value(), battleId.value());
    }

}
