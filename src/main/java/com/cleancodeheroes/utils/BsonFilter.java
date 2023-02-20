package com.cleancodeheroes.utils;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class BsonFilter {
    public final Bson filter;

    public BsonFilter (String id) {
        this.filter = Filters.eq(
                "_id",
                new ObjectId(id)
        );
    }

    public BsonFilter (String paramName, Object paramValue) {
        this.filter = Filters.eq(paramName, paramValue);
    }
}
