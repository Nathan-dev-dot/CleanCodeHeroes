package com.cleancodeheroes.card.application.port.out;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.card.domain.CardId;

public interface CreateCardPort {
    CardId save (Card card) throws IllegalArgumentException;
}
