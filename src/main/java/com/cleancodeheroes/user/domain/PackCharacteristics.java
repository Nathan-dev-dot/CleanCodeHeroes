package com.cleancodeheroes.user.domain;

public class PackCharacteristics {
    private final PackType type;
    private final Integer requiredTokens;
    private final Integer numberOfCards;
    private final Double legendaryDropPercentage;
    private final Double rareDropPercentage;
    private final Double commonDropPercentage;

    private PackCharacteristics(
            PackType packType,
            Integer requiredTokens,
            Integer numberOfCards,
            Double legendaryDropPercentage,
            Double rareDropPercentage,
            Double commonDropPercentage
    ) {
        this.type = packType;
        this.requiredTokens = requiredTokens;
        this.numberOfCards = numberOfCards;
        this.legendaryDropPercentage = legendaryDropPercentage;
        this.rareDropPercentage = rareDropPercentage;
        this.commonDropPercentage = commonDropPercentage;
    }

    public static PackCharacteristics Silver () {
        return new PackCharacteristics(
                PackType.Silver,
                1,
                3,
                0.05,
                0.2,
                0.75
        );
    }

    public static PackCharacteristics Diamond () {
        return new PackCharacteristics(
                PackType.Diamond,
                2,
                5   ,
                0.15,
                0.35,
                0.50
        );
    }

    public static PackCharacteristics of (PackType packType) throws IllegalArgumentException {
        switch (packType) {
            case Silver -> {
                return Silver();
            }
            case Diamond -> {
                return Diamond();
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + packType);
        }
    }

    public PackType getType() {
        return type;
    }

    public Integer getRequiredTokens() {
        return requiredTokens;
    }

    public Integer getNumberOfCards() {
        return numberOfCards;
    }

    public Double getLegendaryDropPercentage() {
        return legendaryDropPercentage;
    }

    public Double getRareDropPercentage() {
        return rareDropPercentage;
    }

    public Double getCommonDropPercentage() {
        return commonDropPercentage;
    }
}
