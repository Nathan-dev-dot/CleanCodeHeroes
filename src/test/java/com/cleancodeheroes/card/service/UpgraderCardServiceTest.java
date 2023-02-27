package com.cleancodeheroes.card.service;

import com.cleancodeheroes.card.application.port.in.UpgradeCardQuery;
import com.cleancodeheroes.card.application.service.UpgraderCardService;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.user.domain.UserId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpgraderCardServiceTest {
    @InjectMocks
    UpgraderCardService upgraderCardService;


    @Test
    public void shouldAddOneExperiencePointToCard () {
        Card inputCard = new Card(new CardProps(
                new CardId().value(),
                new HeroId().value(),
                "Test",
                700,
                0,
                300,
                15,
                "Assassin",
                "Rare",
                3,
                new UserId().value()
        ));
        Card expectedCard = new Card(new CardProps(
                inputCard.getId().value(),
                inputCard.getParentHeroId().value(),
                inputCard.getName(),
                inputCard.getHealthPoints().value(),
                inputCard.getExperiencePoints().value() + 1,
                inputCard.getPower().value(),
                inputCard.getArmour().value(),
                inputCard.getSpecialty().value().name(),
                inputCard.getRarity().value().name(),
                inputCard.getLevel().value(),
                inputCard.getUserId().value()
        ));
        try {
            Card actual = this.upgraderCardService.handle(new UpgradeCardQuery(inputCard));
            Assertions.assertEquals(expectedCard, actual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void shouldAddOneExperiencePointToCardAndLevelUp () {
        Card inputCard = new Card(new CardProps(
                new CardId().value(),
                new HeroId().value(),
                "Test",
                700,
                4,
                300,
                15,
                "Assassin",
                "Rare",
                3,
                new UserId().value()
        ));
        Card expectedCard = new Card(new CardProps(
                inputCard.getId().value(),
                inputCard.getParentHeroId().value(),
                inputCard.getName(),
                inputCard.getHealthPoints().increaseByFactor().value(),
                inputCard.getExperiencePoints().value() + 1,
                inputCard.getPower().increaseByFactor().value(),
                inputCard.getArmour().increaseByFactor().value(),
                inputCard.getSpecialty().value().name(),
                inputCard.getRarity().value().name(),
                inputCard.getLevel().value() + 1,
                inputCard.getUserId().value()
        ));
        try {
            Card actual = this.upgraderCardService.handle(new UpgradeCardQuery(inputCard));
            Assertions.assertEquals(expectedCard, actual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
