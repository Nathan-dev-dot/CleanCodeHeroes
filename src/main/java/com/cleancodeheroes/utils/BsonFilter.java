package com.cleancodeheroes.utils;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

public class BsonFilter {
    public static Bson byId (String id) {
        return Filters.eq(
                "_id",
                IdUtils.fromStringToObjectId(id)
        );
    }
}
