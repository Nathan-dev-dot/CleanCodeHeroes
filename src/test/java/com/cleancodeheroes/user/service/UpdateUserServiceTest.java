package com.cleancodeheroes.user.service;

import com.cleancodeheroes.user.application.port.in.UpdateUserCommand;
import com.cleancodeheroes.user.application.port.out.UpdateUserPort;
import com.cleancodeheroes.user.application.services.UserUpdatingService;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.domain.UserProps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateUserServiceTest {
    @InjectMocks
    UserUpdatingService userUpdatingService;

    @Mock
    UpdateUserPort noSQLUserPersistence;

    @Test
    public void shouldUpdateUser () {
        UserId userId = new UserId();
        when(noSQLUserPersistence.update(any(User.class))).thenReturn(userId);
        UserId savedId = userUpdatingService.handle(new UpdateUserCommand(new User(new UserProps("Test"))));
        Assertions.assertEquals(userId, savedId);
    }
}
