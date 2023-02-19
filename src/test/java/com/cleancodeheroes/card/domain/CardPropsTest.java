package com.cleancodeheroes.card.domain;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardPropsTest {
    @Test
    public void shouldCreateCardProps() {
        CardProps cardProps = new CardProps(
                new ObjectId().toString(),
                new ObjectId().toString(),
                "Test",
                0,
                0,
                0,
                0,
                "Tank",
                "Rare",
                1,
                new ObjectId().toString()
        );
        Assertions.assertTrue(ObjectId.isValid(cardProps.id.value()));
        Assertions.assertTrue(ObjectId.isValid(cardProps.parentHeroId.value()));
        Assertions.assertEquals("Test", cardProps.name);
        Assertions.assertEquals(0, cardProps.healthPoints.getHealthPoint());
        Assertions.assertEquals(0, cardProps.experiencePoints.getExperiencePoint());
        Assertions.assertEquals(0, cardProps.power.getPower());
        Assertions.assertEquals(0, cardProps.armour.getArmour());
        Assertions.assertEquals("Tank", cardProps.specialty.toString());
        Assertions.assertEquals("Rare", cardProps.rarity.toString());
        Assertions.assertEquals(1, cardProps.level.getLevel());
    }

    @Test
    public void shouldThrowIfInvalidCardId() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        "Invalid",
                        new ObjectId().toString(),
                        "Test",
                        0,
                        0,
                        0,
                        0,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }

    @Test
    public void shouldThrowIfInvalidParentHeroId() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        0,
                        0,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidHealthPoints() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        -1,
                        0,
                        0,
                        0,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidExperiencePoints() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        -1,
                        0,
                        0,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidPower() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        -1,
                        0,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidArmour() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        0,
                        -1,
                        "Tank",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidSpecialty() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        0,
                        0,
                        "Invalid",
                        "Rare",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidRarity() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        0,
                        0,
                        "Tank",
                        "Invalid",
                        1,
                        new ObjectId().toString()
                ));
    }
    @Test
    public void shouldThrowIfInvalidLevel() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CardProps(
                        new ObjectId().toString(),
                        "Invalid",
                        "Test",
                        0,
                        0,
                        0,
                        0,
                        "Tank",
                        "Rare",
                        0,
                        new ObjectId().toString()
                ));
    }

    @Test
    public void shouldCreatePropsFromValidCard () {
        CardProps cardProps = new CardProps(
                new ObjectId().toString(),
                new ObjectId().toString(),
                "Test",
                0,
                0,
                0,
                0,
                "Tank",
                "Rare",
                1,
                new ObjectId().toString()
        );
        Card card = new Card(cardProps);
        CardProps newCardProps = CardProps.of(card);
        Assertions.assertEquals(cardProps, newCardProps);
    }
}