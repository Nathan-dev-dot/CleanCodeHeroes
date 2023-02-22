package com.cleancodeheroes.user.domain;

import org.bson.types.ObjectId;

import java.util.Objects;

public final class UserId {
    private final String id;

    private UserId(String userId){
        this.id = userId;
    }

    public UserId () {
        this.id = new ObjectId().toString();
    }

    public static UserId of(String userId){
        if (ObjectId.isValid(userId))
            return new UserId(userId);
        throw new IllegalArgumentException(userId);
    }

    public String value(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId userId1)) return false;
        return id.equals(userId1.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
