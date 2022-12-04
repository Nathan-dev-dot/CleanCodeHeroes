package com.cleancodeheroes.utils;

import java.util.UUID;

public final class IdUtils {
    public static UUID UUIDFromString (String id) throws IllegalArgumentException {
        return UUID.fromString(id);
    }

    public static UUID newUUID () {
        return UUID.randomUUID();
    }
}
