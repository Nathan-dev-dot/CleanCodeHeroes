package com.cleancodeheroes.card.service;

import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.application.port.out.CreateCardPort;
import com.cleancodeheroes.card.application.service.CreationCardService;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
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
public class CreationCardServiceTest {
    @InjectMocks
    CreationCardService creationCardService;

    @Mock
    CreateCardPort createCardPort;

    @Mock
    Hero hero;

    @Test
    public void shouldCreateNewCard() {
        Hero hero = new HeroBuilder().id().name("Test").specialty("Tank").rarity("Rare").basicStats().build();
        Card card = new Card(new CardProps(
                new CardId().value(),
                hero.Id().value(),
                "Test",
                hero.HealthPoints().value(),
                0,
                hero.Power().value(),
                hero.Armour().value(),
                hero.Specialty().value().name(),
                hero.Rarity().value().name(),
                1,
                new UserId().value()
        ));
        when(createCardPort.save(any(Card.class))).thenReturn(card.getId());
        CardId cardId = this.creationCardService.handle(new CreateCardCommand(hero, card.getUserId()));
    }

    @Test
    public void shouldThrowOnCreateError () {
        Hero hero = new HeroBuilder().id().name("Test").specialty("Tank").rarity("Rare").basicStats().build();
        UserId userId = new UserId();
        when(createCardPort.save(any(Card.class))).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.creationCardService.handle(new CreateCardCommand(hero, userId))
        );
    }
}
