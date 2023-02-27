package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class ExperiencePoint{
    private final Integer experiencePoint;

    private ExperiencePoint(Integer experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public static ExperiencePoint of (Integer experiencePoint) throws IllegalArgumentException {
        if (experiencePoint < 0)
            throw new IllegalArgumentException();
        return new ExperiencePoint(experiencePoint);
    }

    public Integer value() {
        return experiencePoint;
    }


    public ExperiencePoint addOnePoint(){
        int newExperiencePointValue = this.experiencePoint + 1;
        return ExperiencePoint.of(newExperiencePointValue);
    }

    public Boolean shouldLevelUp(){
        return this.experiencePoint % 5 == 0;
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
