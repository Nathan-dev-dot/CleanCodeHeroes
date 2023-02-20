package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.kernel.query.Query;

public class UpgradeCardQuery implements Query {
    public final Card card;

    public UpgradeCardQuery(Card card) {
        this.card = card;
    }
}
