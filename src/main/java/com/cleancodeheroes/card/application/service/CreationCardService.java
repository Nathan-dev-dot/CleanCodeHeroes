package com.cleancodeheroes.card.application.service;

import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.application.port.in.CreateCardUseCase;
import com.cleancodeheroes.card.application.port.out.CreateCardPort;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;
import com.cleancodeheroes.card.domain.CardProps;
import org.springframework.stereotype.Service;

@Service
public final class CreationCardService implements CreateCardUseCase {
    private final CreateCardPort createCardPort;

    public CreationCardService(CreateCardPort createCardPort) { this.createCardPort = createCardPort; }

    @Override
    public CardId handle(CreateCardCommand command) throws IllegalArgumentException {
        CardId cardId = new CardId();
        Card card = new Card(
                new CardProps(
                        cardId.value(),
                        command.getHeroId().value(),
                        command.getName(),
                        command.getHealthPoints(),
                        command.getExperiencePoints(),
                        command.getPower(),
                        command.getArmour(),
                        command.getSpecialty().toString(),
                        command.getRarity().toString(),
                        command.getLevel()
                )
        );
        return this.createCardPort.save(card);
    }
}
