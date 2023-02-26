package com.cleancodeheroes.user.service;

import com.cleancodeheroes.user.application.port.in.UpdateUserVictoriesQuery;
import com.cleancodeheroes.user.application.services.UserVictoriesUpdatingService;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.domain.UserProps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class UserVictoriesUpdatingServiceTest {

    @InjectMocks
    UserVictoriesUpdatingService userVictoriesUpdatingService;

    @Test
    public void shouldUpdateVictory () {
        User user = new User(new UserProps("Test"));
        int victoriesBeforeUpdate = user.getVictories().value();
        UpdateUserVictoriesQuery query = new UpdateUserVictoriesQuery(user);
        User updatedUser = userVictoriesUpdatingService.handle(query);
        Assertions.assertEquals(victoriesBeforeUpdate + 1, updatedUser.getVictories().value());
    }

    @Test
    public void shouldUpdateVictoryAndAddToken () {
        User user = new User(new UserProps(
                new UserId().value(),
                "Test",
                0,
                new ArrayList<String>(),
                4));
        int victoriesBeforeUpdate = user.getVictories().value();
        int tokensBeforeUpdate = user.getToken().value();
        UpdateUserVictoriesQuery query = new UpdateUserVictoriesQuery(user);
        User updatedUser = userVictoriesUpdatingService.handle(query);
        Assertions.assertEquals(victoriesBeforeUpdate + 1, updatedUser.getVictories().value());
        Assertions.assertEquals(tokensBeforeUpdate + 1, updatedUser.getToken().value());
    }
}
