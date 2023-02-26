package com.cleancodeheroes.battle.appllication.service;

import com.cleancodeheroes.battle.adapter.out.NoBattleFoundException;
import com.cleancodeheroes.battle.application.port.in.FindBattleByHeroIdQuery;
import com.cleancodeheroes.battle.application.port.out.FindBattleByHeroIdPort;
import com.cleancodeheroes.battle.application.service.FinderBattleByHeroIdService;
import com.cleancodeheroes.battle.domain.BattleResult;
import com.cleancodeheroes.hero.domain.HeroId;
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
public class FinderBattleByHeroIdServiceTest {

    @InjectMocks
    FinderBattleByHeroIdService finderBattleByHeroIdService;
    @Mock
    FindBattleByHeroIdPort findBattleByUserIdPort;
    @Test
    public void shouldReturnAnArrayListOfBattleResult() {
        FindBattleByHeroIdQuery findBattleByHeroIdQuery = new FindBattleByHeroIdQuery(new ObjectId().toString());
        try{
            when(findBattleByUserIdPort.loadBattleByHeroId(any(HeroId.class))).thenReturn(new ArrayList<>());
            ArrayList<BattleResult> battleResults = (ArrayList<BattleResult>) this.finderBattleByHeroIdService.handle(findBattleByHeroIdQuery);
            Assertions.assertEquals(battleResults.getClass(), ArrayList.class);
        } catch (NoBattleFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
