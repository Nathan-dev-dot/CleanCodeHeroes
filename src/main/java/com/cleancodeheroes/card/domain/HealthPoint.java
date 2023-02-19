package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class HealthPoint implements Characteristic{
    private final Integer healthPoint;

    private HealthPoint(Integer healthPoint) {
        this.healthPoint = healthPoint;
    }

    public static HealthPoint of (Integer healthPoint) throws IllegalArgumentException {
        if (healthPoint < 0)
            throw new IllegalArgumentException();
        return new HealthPoint(healthPoint);
    }

    public Integer value() {
        return healthPoint;
    }

    @Override
    public HealthPoint increaseByFactor(){
        int newHealthPointValue = (int) Math.abs(this.healthPoint * increaseFactor);
        return HealthPoint.of(newHealthPointValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthPoint that)) return false;
        return Objects.equals(healthPoint, that.healthPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoint);
    }

}
