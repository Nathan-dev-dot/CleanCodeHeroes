package com.cleancodeheroes.user.domain;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
public class UserPropsTest {

    @Test
    public void shouldCreateFullUserProps () {
        String id = new ObjectId().toString();
        UserProps userProps = new UserProps(
                id,
                "Test",
                new Token().value(),
                new Deck().getCards(),
                new Victories().value()
        );

        Assertions.assertEquals(id, userProps.userId.value());
        Assertions.assertEquals("Test", userProps.username);
        Assertions.assertEquals(4, userProps.token.value());
        Assertions.assertEquals(new ArrayList<String>(), userProps.deck.getCards());
        Assertions.assertEquals(0, userProps.victories.value());
    }

    @Test
    public void shouldCreateUserPropsFromUsername () {
        UserProps userProps = new UserProps("Test");
        Assertions.assertTrue(ObjectId.isValid(userProps.userId.value()));
        Assertions.assertEquals("Test", userProps.username);
        Assertions.assertEquals(4, userProps.token.value());
        Assertions.assertEquals(new ArrayList<String>(), userProps.deck.getCards());
        Assertions.assertEquals(0, userProps.victories.value());
    }
}
