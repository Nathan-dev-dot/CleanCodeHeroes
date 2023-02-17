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

    public ExperiencePoint addTenPercentOfExperiencePoint(){
        int newExperiencePointValue = (int) Math.abs(this.experiencePoint * 1.1);
        return new ExperiencePoint(newExperiencePointValue);
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
