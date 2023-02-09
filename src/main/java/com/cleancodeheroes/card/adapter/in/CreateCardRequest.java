package com.cleancodeheroes.card.adapter.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class CreateCardRequest {
    @NotNull
    @NotEmpty
    public String baseHeroId;
}
