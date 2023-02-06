package com.cleancodeheroes.card.domain;

import org.bson.types.ObjectId;

import java.util.Objects;

public final class CardId {
    private final String id;

    private CardId (String id) { this.id = id; }

    public static CardId of (String stringId) throws IllegalArgumentException {
        if (ObjectId.isValid(stringId))
            return new CardId(stringId);
        throw new IllegalArgumentException(stringId);
    }

    public static CardId of (ObjectId object) { return new CardId(object.toString()); }

    public String value () { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardId cardId)) return false;
        return id.equals(cardId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
