package com.cleancodeheroes.card.service;

import com.cleancodeheroes.card.application.port.in.FindCardQuery;
import com.cleancodeheroes.card.application.port.out.FindCardPort;
import com.cleancodeheroes.card.application.service.FinderCardService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinderCardServiceTest {
    @InjectMocks
    FinderCardService finderCardService;

    @Mock
    FindCardPort findCardPort;

    @Test
    public void shouldFindCard () {
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
        try {
            when(this.findCardPort.load(expectedCard.getId())).thenReturn(expectedCard);
            Card actual = this.finderCardService.handle(new FindCardQuery(expectedCard.getId().value()));
            Assertions.assertEquals(expectedCard, actual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void shouldNotFindCard () {
        try {
            when(this.findCardPort.load(any(CardId.class))).thenThrow(new IllegalArgumentException());
            Assertions.assertThrows(IllegalArgumentException.class, () -> this.finderCardService.handle(new FindCardQuery(new CardId().value())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
