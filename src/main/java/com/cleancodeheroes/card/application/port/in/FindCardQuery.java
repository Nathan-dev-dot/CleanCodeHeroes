package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.kernel.query.Query;

public class FindCardQuery implements Query {
    public final String cardId;

    public FindCardQuery (String cardId) { this.cardId = cardId; }
}
