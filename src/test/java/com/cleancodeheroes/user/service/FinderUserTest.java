package com.cleancodeheroes.user.service;

import com.cleancodeheroes.user.adapter.out.UserNotFoundException;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.application.port.out.FindUserPort;
import com.cleancodeheroes.user.application.services.UserFindingService;
import com.cleancodeheroes.user.domain.User;
import com.cleancodeheroes.user.domain.UserId;
import com.cleancodeheroes.user.domain.UserProps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinderUserTest {

    @InjectMocks
    UserFindingService finderUserService;

    @Mock
    FindUserPort findUserPort;

    @Test
    public void shouldFindUser () {
        User user = new User(new UserProps("Test"));
        UserId userId = user.getUserId();
        try {
            when(findUserPort.load(userId)).thenReturn(user);
            User actual = this.finderUserService.handle(new FindUserQuery(userId.value()));
            Assertions.assertEquals(user, actual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void shouldNotFindUser () {
        UserId userId = new UserId();
        try {
            when(findUserPort.load(userId)).thenThrow(new UserNotFoundException());
            Assertions.assertThrows(UserNotFoundException.class, () -> this.finderUserService.handle(new FindUserQuery(userId.value())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
