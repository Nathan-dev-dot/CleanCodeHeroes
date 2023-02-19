package com.cleancodeheroes.battle.domain;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.shared.domain.SpecialtyCharacteristics;

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

    private Card fight(){
        int nbRoundsToKillAttacker = this.roundToKillCard(defenderCard, attackerCard);
        int nbRoundsToKillDefender = this.roundToKillCard(attackerCard, defenderCard);
        if (nbRoundsToKillDefender <= nbRoundsToKillAttacker) return this.attackerCard;
        return this.defenderCard;
    }

    private int roundToKillCard (Card attacker, Card defender) {
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
