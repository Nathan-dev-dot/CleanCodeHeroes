package com.cleancodeheroes.card.application.port.out;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;

public interface UpdateCardPort {
    CardId update(Card card);
}
