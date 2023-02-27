package com.cleancodeheroes.card.service;

import com.cleancodeheroes.card.application.port.in.UpdateCardCommand;
import com.cleancodeheroes.card.application.port.out.UpdateCardPort;
import com.cleancodeheroes.card.application.service.CardUpdatingService;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.user.domain.UserId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardUpdatingServiceTest {
    @InjectMocks
    CardUpdatingService cardUpdatingService;

    @Mock
    UpdateCardPort updateCardPort;

    @Test
    public void shouldUpdateCard () {
        Card expectedCard = new Card(new CardProps(
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
        when(this.updateCardPort.update(expectedCard)).thenReturn(expectedCard.getId());
        CardId updatedId = this.cardUpdatingService.handle(new UpdateCardCommand(expectedCard));
        Assertions.assertEquals(expectedCard.getId(), updatedId);
    }
}
