package com.cleancodeheroes.card.application.service;

import com.cleancodeheroes.card.application.port.in.UpdateCardCommand;
import com.cleancodeheroes.card.application.port.in.UpdateCardUseCase;
import com.cleancodeheroes.card.application.port.out.UpdateCardPort;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;

public class CardUpdatingService implements UpdateCardUseCase {

    private final UpdateCardPort updateCardPort;

    public CardUpdatingService(UpdateCardPort updateCardPort) { this.updateCardPort = updateCardPort; }

    @Override
    public CardId handle(UpdateCardCommand command) {
        Card card = command.card;
        return this.updateCardPort.update(card);
    }
}
