package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;

import java.util.Objects;

public final class Battle {
    //TODO battleId
    private final Card attackerCard;
    private final Card defenderCard;

    public Battle(Card attackerCard, Card defenderCard) {
        this.attackerCard = attackerCard;
        this.defenderCard = defenderCard;
    }

    public Card getAttackerCard() {
        return attackerCard;
    }

    public Card getDefenderCard() {
        return defenderCard;
    }

    public Card fight(){
        //TODO
        return this.attackerCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Battle battle)) return false;
        return Objects.equals(attackerCard, battle.attackerCard) && Objects.equals(defenderCard, battle.defenderCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attackerCard, defenderCard);
    }
}
