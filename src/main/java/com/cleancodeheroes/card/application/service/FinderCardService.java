package com.cleancodeheroes.card.application.service;

import com.cleancodeheroes.card.application.port.in.FindCardQuery;
import com.cleancodeheroes.card.application.port.in.FindCardUseCase;
import com.cleancodeheroes.card.application.port.out.FindCardPort;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;

public class FinderCardService implements FindCardUseCase {
    private final FindCardPort findCardPort;

    public FinderCardService (FindCardPort findCardPort) { this.findCardPort = findCardPort; }

    @Override
    public Card handle(FindCardQuery query) throws Exception {
        return this.findCardPort.load(CardId.of(query.cardId));
    }
}
