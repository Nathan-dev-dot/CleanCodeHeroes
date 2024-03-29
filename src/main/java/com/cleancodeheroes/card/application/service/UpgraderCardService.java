package com.cleancodeheroes.card.application.service;

import com.cleancodeheroes.card.application.port.in.UpgradeCardQuery;
import com.cleancodeheroes.card.application.port.in.UpgradeCardUseCase;
import com.cleancodeheroes.card.domain.Card;

public class UpgraderCardService implements UpgradeCardUseCase {
    @Override
    public Card handle(UpgradeCardQuery query) throws Exception {
        Card card = query.card;
        card.setExperiencePoints(card.getExperiencePoints().addOnePoint());
        if(card.getExperiencePoints().shouldLevelUp()){
            card.setLevel(card.getLevel().addOneLevel());
            card.setArmour(card.getArmour().increaseByFactor());
            card.setHealthPoints(card.getHealthPoints().increaseByFactor());
            card.setPower(card.getPower().increaseByFactor());
        }
        return card;
    }
}
