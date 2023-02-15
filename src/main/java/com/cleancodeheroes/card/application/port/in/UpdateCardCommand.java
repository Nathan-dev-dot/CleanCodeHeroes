package com.cleancodeheroes.card.application.port.in;

import com.cleancodeheroes.card.domain.Card;
import com.cleancodeheroes.kernel.command.Command;

public class UpdateCardCommand implements Command {
    public final Card card;

    public UpdateCardCommand(Card card) {
        this.card = card;
    }

}
