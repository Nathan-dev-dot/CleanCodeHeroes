package com.cleancodeheroes.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Token {
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
    public Token minusOne() throws ArithmeticException{
        if(this.numberOfToken > 0){
            return new Token(this.numberOfToken - 1);
        }else {
            throw new ArithmeticException();
        }
    }


    public Token plusOneToken(){
        return new Token(this.numberOfToken + 1);
    }
}
