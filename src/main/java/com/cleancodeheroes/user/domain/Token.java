package com.cleancodeheroes.user.domain;

public class Token {
    private final int numberOfToken;

    private Token(int numberOfToken){
        this.numberOfToken = numberOfToken;
    }

    public static Token of(int numberOfToken){
        return new Token(numberOfToken);
    }

    public Token minusOne(){
        if(this.numberOfToken > 0){
            return Token.of(this.numberOfToken - 1);
        }else {
            throw new RuntimeException();
        }
    }


    public Token plusOneToken(){
        return Token.of(this.numberOfToken + 1);
    }
}
