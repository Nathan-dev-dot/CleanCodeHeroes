package com.cleancodeheroes.battle.domain;

import org.bson.types.ObjectId;

import java.util.Objects;

public final class BattleId {
    private final String id;

    private BattleId(String battleId){
        this.id = battleId;
    }

    public BattleId() {
        this.id = new ObjectId().toString();
    }

    public static BattleId of(String battleId){
        if (ObjectId.isValid(battleId))
            return new BattleId(battleId);
        throw new IllegalArgumentException(battleId);
    }

    public String value(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BattleId battleId1)) return false;
        return id.equals(battleId1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
