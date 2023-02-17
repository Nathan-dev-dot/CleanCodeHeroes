package com.cleancodeheroes.card.domain;

public interface Characteristic {
    Double increaseFactor = 1.1;

    <R> R increaseByFactor();
}
