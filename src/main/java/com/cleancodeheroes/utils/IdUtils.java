package com.cleancodeheroes.utils;

import org.bson.BsonValue;
import org.bson.types.ObjectId;

final public class IdUtils {

    public static String fromBsonValueToString (BsonValue bson) {
        return bson.asObjectId().getValue().toString();
    }

    public static ObjectId fromStringToObjectId (String id) {
        return new ObjectId(id);
    }

//    public static UUID UUIDFromString (String id) throws IllegalArgumentException {
//        return UUID.fromString(id);
//    }

//    public static UUID newUUID () {
//        return UUID.randomUUID();
//    }
}
