package com.cleancodeheroes.battle.domain;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BattleIdTest {

    @Test
    public void shouldCreateBattleId(){
        String objectId = new ObjectId().toString();
        BattleId battleId = BattleId.of(objectId);
        Assertions.assertEquals(battleId.value(), objectId);
        Assertions.assertEquals(battleId.value().getClass(), String.class);
    }

    @Test
    public void shouldThrowIllegalArgumentException(){
        String objectId = "c'estUnMauvaisID";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                BattleId.of(objectId);
        });
    }
}
