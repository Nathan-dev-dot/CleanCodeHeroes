package com.cleancodeheroes.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public final class Token {
    private final int numberOfToken;

    public Token(int numberOfToken){
        this.numberOfToken = numberOfToken;
    }

    public int value(){
        return this.numberOfToken;
    }
    public int getNumberOfToken(){
        return this.numberOfToken;
    }
    public Token minus(PackType packType) throws ArithmeticException{
        PackCharacteristics packCharacteristics = PackCharacteristics.of(packType);
        int newNumberOfToken = this.numberOfToken - packCharacteristics.getRequiredTokens();
        if (newNumberOfToken < 0) throw new ArithmeticException();
        return new Token(newNumberOfToken);
    }


    public Token plusOneToken(){
        return new Token(this.numberOfToken + 1);
    }
}
