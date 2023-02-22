package com.cleancodeheroes.utils;

public class CharacteristicUtils {
    public static Integer increaseByFactor (Integer value, Double factor) {
        Double result = value * factor;
        return result.intValue();
    }
}
