package com.cleancodeheroes.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class IdUtilsTest {

    @Test
    public void shouldReturnUUIDFromString () {
        final UUID actual = UUID.randomUUID();
        Assertions.assertEquals(actual, IdUtils.UUIDFromString(actual.toString()));
    }

    @Test
    public void shouldThrowExeptionForInvalidString () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IdUtils.UUIDFromString("azerty");
        });
    }

    @Test
    public void shouldCreateRandomUUID () {
        Assertions.assertNotNull(IdUtils.newUUID());
    }
}