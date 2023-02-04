package com.cleancodeheroes.user.domain;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;

import java.util.Objects;
@JsonSerialize
public class UserId {
    private final String userId;

    private UserId(String userId){
        this.userId = userId;
    }

    public static UserId of(String userId){
        if (ObjectId.isValid(userId))
            return new UserId(userId);
        throw new IllegalArgumentException(userId);
    }

    public String getUserId(){
        return this.userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId userId1)) return false;
        return userId.equals(userId1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
