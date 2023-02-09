package com.cleancodeheroes.card.application.port.out;

import com.cleancodeheroes.card.application.CardNotFoundException;
import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;

public interface FindCardPort {
    Card load (CardId cardId) throws CardNotFoundException;
}
