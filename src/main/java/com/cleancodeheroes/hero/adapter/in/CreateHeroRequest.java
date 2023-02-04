package com.cleancodeheroes.hero.adapter.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateHeroRequest {
    @NotNull
    @NotEmpty
    public String name ;

    @NotNull
    @NotEmpty
    public Integer healthPoints  ;

    @NotNull
    @NotEmpty
    public Integer experiencePoints ;

    @NotNull
    @NotEmpty
    public Integer power ;

    @NotNull
    @NotEmpty
    public Integer armour ;

    @NotNull
    @NotEmpty
    public String specialty;

    @NotNull
    @NotEmpty
    public String rarity ;
    
    @NotNull
    @NotEmpty
    public Integer level ;
}
