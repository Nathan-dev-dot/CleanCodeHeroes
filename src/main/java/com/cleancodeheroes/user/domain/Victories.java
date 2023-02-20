package com.cleancodeheroes.user.domain;

public class Victories {
    private int victories ;

    private Victories (int count) {
        this.victories = count;
    }

    public Victories () {
        this.victories = 0 ;
    }

    public static Victories of (int count) throws IllegalArgumentException {
        if (count < 0)
            throw new IllegalArgumentException();
        return new Victories(count);
    }

    public int value () {
        return this.victories;
    }

    public Victories addOne () {
        return new Victories(this.victories + 1);
    }
}
