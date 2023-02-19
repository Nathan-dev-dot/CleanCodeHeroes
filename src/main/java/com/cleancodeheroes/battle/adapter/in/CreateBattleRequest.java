package com.cleancodeheroes.battle.adapter.in;

public class CreateBattleRequest {
    public final String attackerId;
    public final String defenderId;

    public CreateBattleRequest(String attackerId, String defenderId) {
        this.attackerId = attackerId;
        this.defenderId = defenderId;
    }
}
