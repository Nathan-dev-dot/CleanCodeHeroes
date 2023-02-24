package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.shared.domain.SpecialtyCharacteristics;

import java.util.Objects;

public final class Battle {
    private final Card attackerCard;
    private final Card defenderCard;

    private Battle(Card attackerCard, Card defenderCard) {
        this.attackerCard = attackerCard;
        this.defenderCard = defenderCard;
    }
    
    public static Battle of (Card attackerCard, Card defenderCard) throws IllegalArgumentException {
        if (Objects.equals(attackerCard.getUserId(), defenderCard.getUserId()))
            throw new IllegalArgumentException();
        return new Battle(attackerCard, defenderCard);
    }
    
    private Card fight(){
        int nbRoundsToKillAttacker = this.roundsToKillCard(defenderCard, attackerCard);
        int nbRoundsToKillDefender = this.roundsToKillCard(attackerCard, defenderCard);
        if (nbRoundsToKillDefender <= nbRoundsToKillAttacker) return this.attackerCard;
        return this.defenderCard;
    }

    private int roundsToKillCard(Card attacker, Card defender) {
        return defender.getHealthPoints().value() / finalAttackerPower(attacker, defender);
    }

    private int finalAttackerPower(Card attacker, Card defender) {
        SpecialtyCharacteristics attackerSpecialtyCharacteristics = SpecialtyCharacteristics.of(attacker.getSpecialty().value());
        Double augmentedPowerAgainstClass = attackerSpecialtyCharacteristics
                .getAdditionalDammageAgainstCharacterType(defender.getSpecialty().value())
                * (1 + attacker.getLevel().value() / 100.0);
        int diminishedPower = attacker.getPower().value() + augmentedPowerAgainstClass.intValue() - defender.getArmour().value();
        return Math.max(diminishedPower, 0);
    }

    public Card getWinner () {
        return this.fight();
    }

    public Card getLoser () {
        return this.fight() == this.attackerCard
                ? this.defenderCard
                :  this.attackerCard;
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
