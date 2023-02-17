package com.cleancodeheroes.user.domain;

public class Pack {
    private final PackType packType;
    private Pack (PackType packType) { this.packType = packType; }

    public static Pack of (String packType) throws IllegalArgumentException {
        return new Pack(PackType.valueOf(packType));
    }

    public PackType value() {
        return packType;
    }
}
