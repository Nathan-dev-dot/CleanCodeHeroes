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
        if(packType == PackType.Silver && this.numberOfToken - 1 >= 0){
            return new Token(this.numberOfToken - 1);
        }else if (packType == PackType.Diamond && this.numberOfToken - 2 >= 0){
            return new Token(this.numberOfToken - 2);
        }else{
            throw new ArithmeticException();
        }
    }


    public Token plusOneToken(){
        return new Token(this.numberOfToken + 1);
    }
}
