package com.cleancodeheroes.battle.appllication.service;

import com.cleancodeheroes.battle.adapter.out.NoBattleFoundException;
import com.cleancodeheroes.battle.application.port.in.FindBattleByUserIdQuery;
import com.cleancodeheroes.battle.application.port.out.FindBattleByUserIdPort;
import com.cleancodeheroes.battle.application.service.FinderBattleByUserIdService;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.user.domain.UserId;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinderBattleByUserIdServiceTest {
    @InjectMocks
    FinderBattleByUserIdService finderBattleByUserIdService;

    @Mock
    FindBattleByUserIdPort findBattleByUserIdPort;

    @Test
    public void shouldReturnBattleResult(){
        try {
            when(this.findBattleByUserIdPort.loadBattleByUserId(any(UserId.class))).thenReturn(new ArrayList<>());
            ArrayList<BattleResult> battleResults = this.finderBattleByUserIdService.handle(new FindBattleByUserIdQuery(new ObjectId().toString()));
            Assertions.assertEquals(battleResults.getClass(), ArrayList.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldThrowIllegalArgumentException(){
        try {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                this.finderBattleByUserIdService.handle(new FindBattleByUserIdQuery("wrong id"));
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
