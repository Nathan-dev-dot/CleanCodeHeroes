package com.cleancodeheroes.utils;

import org.bson.BsonValue;
import org.bson.types.ObjectId;

public final class IdUtils {

    public static String fromBsonValueToString (BsonValue bson) {
        return bson.asObjectId().getValue().toString();
    }

    public static ObjectId fromStringToObjectId (String id) {
        return new ObjectId(id);
    }

    public static String fromObjectIdToString (ObjectId id) {
        return id.toString();
    }

}
