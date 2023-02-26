package com.cleancodeheroes.utils;

public class Random {
    private double value;

    public Random() {
        this.value = Math.random();
    }

    public void run() {
        this.value = Math.random();
    }

    public int intvalue () {
        return (int) this.value * 100;
    }

    public double value () {
        return this.value;
    }
}
