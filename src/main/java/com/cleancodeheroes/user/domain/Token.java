package com.cleancodeheroes.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Token {
    private final int numberOfToken;

    private Token(int numberOfToken){
        this.numberOfToken = numberOfToken;
    }

    public static Token of(int numberOfToken){
        return new Token(numberOfToken);
    }

    public int value(){
        return this.numberOfToken;
    }
    public int getNumberOfToken(){
        return this.numberOfToken;
    }
    public Token minusOne(){
        if(this.numberOfToken > 0){
            return Token.of(this.numberOfToken - 1);
        }else {
            throw new ArithmeticException();
        }
    }


    public Token plusOneToken(){
        return Token.of(this.numberOfToken + 1);
    }
}
