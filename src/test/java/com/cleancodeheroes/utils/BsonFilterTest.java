package com.cleancodeheroes.utils;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BsonFilterTest {

    @Test
    public void shouldReturnFilterWithCorrectId () {
        String validIdString = "63dfd2ca50495666ab6c4a78";
        BsonFilter actual = new BsonFilter(validIdString);
        Bson expected = Filters.eq("_id", new ObjectId(validIdString));
        Assertions.assertEquals(expected, actual.filter);
    }

    @Test
    public void shouldThrowForInvalidId () {
        String invalidObjectId = "invalid";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BsonFilter(invalidObjectId));
    }

    @Test
    public void shouldCreateCustomFilter () {
        BsonFilter filter = new BsonFilter("param", "value");
        Bson expected = Filters.eq("param", "value");
        Assertions.assertEquals(expected, filter.filter);
    }
}
