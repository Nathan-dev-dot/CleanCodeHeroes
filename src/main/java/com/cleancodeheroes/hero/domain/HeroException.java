package com.cleancodeheroes.hero.domain;

public final class HeroException extends Exception{
    private HeroException(String message) { super(message); }

    public static HeroException notFoundHeroId(HeroId heroId){
        return new HeroException(String.format("%s not found", heroId.value()));
    }
}
