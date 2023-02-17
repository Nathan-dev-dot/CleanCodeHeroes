package com.cleancodeheroes.user.domain;

public final class Token {
    private final int numberOfToken;

    private Token(int numberOfToken){
        this.numberOfToken = numberOfToken;
    }

    public static Token of (int numberOfToken) throws IllegalArgumentException {
        if (numberOfToken < 0) throw new IllegalArgumentException();
        return new Token(numberOfToken);
    }

    public int value(){
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
