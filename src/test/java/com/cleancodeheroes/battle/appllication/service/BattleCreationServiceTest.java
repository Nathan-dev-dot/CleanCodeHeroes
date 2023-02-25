package com.cleancodeheroes.battle.appllication.service;

import com.cleancodeheroes.battle.adapter.out.NoSQLBattlePersistence;
import com.cleancodeheroes.battle.application.service.BattleCreationService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
public class BattleCreationServiceTest {

    @InjectMocks
    private BattleCreationService battleCreationService;

    @Mock
    NoSQLBattlePersistence noSQLBattlePersistence;


}
