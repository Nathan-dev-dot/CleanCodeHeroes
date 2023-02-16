package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class ExperiencePoint {
    private final Integer experiencePoint;

    public ExperiencePoint(Integer experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public Integer getExperiencePoint() {
        return experiencePoint;
    }

    public ExperiencePoint addExperiencePoint(Integer experiencePoint){
        if (experiencePoint < 1){
            throw new ArithmeticException();
        }
        return new ExperiencePoint(this.experiencePoint + experiencePoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperiencePoint that)) return false;
        return Objects.equals(experiencePoint, that.experiencePoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experiencePoint);
    }

}
