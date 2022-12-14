package com.cleancodeheroes.hero.adapter.in;

import javax.validation.constraints.NotNull;

public class CreateHeroRequest {
    @NotNull
    public String name ;

    @NotNull
    public Integer healthPoints  ;

    @NotNull
    public Integer experiencePoints ;

    @NotNull
    public Integer power ;

    @NotNull
    public Integer armour ;

    @NotNull
    public String specialty;

    @NotNull
    public String rarity ;
    
    @NotNull
    public Integer level ;
}
