package com.cleancodeheroes.card.domain;

import java.util.Objects;

public class Level {
    private final Integer level;

    private Level(Integer level) {
        this.level = level;
    }
    
    public static Level of (Integer level) throws IllegalArgumentException {
        if (level < 1)
            throw new IllegalArgumentException();
        return new Level(level);
    }

    public Level addOneLevel(){
        return Level.of(this.level + 1);
    }

    public Integer getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Level level1)) return false;
        return Objects.equals(level, level1.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
