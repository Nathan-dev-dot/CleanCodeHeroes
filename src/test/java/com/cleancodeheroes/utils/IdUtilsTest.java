package com.cleancodeheroes.utils;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public final class IdUtilsTest {
    @Test
    public void shouldReturnStringFromObjectId () {
        ObjectId objectId = new ObjectId();
        String stringId = objectId.toString();
        Assertions.assertEquals(objectId, IdUtils.fromStringToObjectId(stringId));
    }

    @Test
    public void shouldReturnObjectIdFromString () {
        ObjectId objectId = new ObjectId();
        String stringId = objectId.toString();
        Assertions.assertEquals(stringId, IdUtils.fromObjectIdToString(objectId));
    }

    @Test
    public void shouldThrowForInvalidString () {
        String invalidId = "Invalid";
        Assertions.assertThrows(IllegalArgumentException.class, () -> IdUtils.fromStringToObjectId(invalidId));
    }
}
