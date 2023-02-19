package com.cleancodeheroes.user.domain;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserIdTest {
    @Test
    public void shouldCreateUserIdFromString () {
        ObjectId id = new ObjectId();
        var userId = UserId.of(id.toString());
        Assertions.assertInstanceOf(UserId.class, userId);
        Assertions.assertEquals(id.toString(), userId.value());
    }

    @Test
    public void shouldThrowForInvalidUserId () {
        String invalidStr = "azerty";
        Assertions.assertThrows(IllegalArgumentException.class, () -> UserId.of(invalidStr));
    }
}
