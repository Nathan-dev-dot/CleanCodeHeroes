package com.cleancodeheroes.hero.adapter.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class CreateHeroRequest {
    @NotNull
    @NotEmpty
    public String name ;

    @NotNull
    @NotEmpty
    public String specialty;

    @NotNull
    @NotEmpty
    public String rarity ;
}
