package com.cleancodeheroes.user.service;

import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.out.CreateUserPort;
import com.cleancodeheroes.user.application.services.UserCreationService;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserCreationServiceTest {

    @InjectMocks
    private UserCreationService userCreationService;

    @Mock
    CreateUserPort noSQLUserPersistence;

    @Test
    public void shouldCreateUser () {
        UserId userId = new UserId();
        when(noSQLUserPersistence.save(any(User.class))).thenReturn(userId);
        UserId savedId = userCreationService.handle(new CreateUserCommand("Test"));
        Assertions.assertEquals(userId, savedId);
    }
}
