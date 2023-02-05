package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.kernel.query.QueryHandler;

public interface FindCardUseCase extends QueryHandler<FindCardQuery, Card> {
}
