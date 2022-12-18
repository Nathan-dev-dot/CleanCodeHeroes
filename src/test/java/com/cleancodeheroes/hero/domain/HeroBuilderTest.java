package com.cleancodeheroes.hero.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.MissingResourceException;
import java.util.UUID;

public class HeroBuilderTest {
    private HeroBuilder heroBuilder = new HeroBuilder();
    Hero hero;

    @BeforeEach
    public void shouldInitBuilder () {
        heroBuilder = new HeroBuilder() ;
    }

    @Test
    public void shouldCreateHeroWithRandomId () {
        hero = heroBuilder.id().build();
        Assertions.assertNotNull(hero.Id());
    }

    @Test
    public void shouldCreateHeroWithGivenId () {
        UUID id = UUID.randomUUID();
        hero = heroBuilder.id(id.toString()).build();
        Assertions.assertEquals(id.toString(), hero.Id().value().toString());
    }

    @Test
    public void shouldThrowForInvalidGivenId () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           heroBuilder.id("azerty").build();
        });
    }
    
    @Test
    public void shouldBuildHeroWithName () {
        String name = "Hero";
        hero = heroBuilder.name(name).build();
        Assertions.assertEquals(name, hero.Name());
    }

    @Test
    public void shouldThrowForHeroNameEmpty () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.name("").build();
        });
    }

    @Test
    public void shouldThrowForInvalidSpecialty () {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            hero = heroBuilder.specialty("Specialty").build() ;
        });
    }

    @Test
    public void shouldBuildTank () {
        hero = heroBuilder.specialty("Tank").build() ;
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
    }

    @Test
    public void shouldBuildAssassin () {
        hero = heroBuilder.specialty("Assassin").build() ;
        Assertions.assertEquals(CharacterType.Assassin, hero.Specialty().value());
    }

    @Test
    public void shouldBuildSorcerer () {
        hero = heroBuilder.specialty("Sorcerer").build() ;
        Assertions.assertEquals(CharacterType.Sorcerer, hero.Specialty().value());
    }

    @Test
    public void shouldThrowForBasicStatsIfNoSpecialty () {
        HeroBuilder heroBuilder = new HeroBuilder();
        Assertions.assertThrows(MissingResourceException.class, () ->{
            hero = heroBuilder.basicStats().build() ;
        });
    }

    @Test
    public void shouldBuildTankBaseCharacteristics () {
        hero = heroBuilder.specialty("Tank").basicStats().build();
        SpecialtyCharacteristics tank = SpecialtyCharacteristics.Tank();
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
        Assertions.assertEquals(tank.getBaseArmour(), hero.Armour());
        Assertions.assertEquals(tank.getBaseHealthPoints(), hero.HealthPoints());
    }

    @Test
    public void shouldBuildAssassinBaseCharacteristics () {
        hero = heroBuilder.specialty("Assassin").basicStats().build();
        SpecialtyCharacteristics assasin = SpecialtyCharacteristics.Assasin();
        Assertions.assertEquals(assasin.getBaseArmour(), hero.Armour());
        Assertions.assertEquals(assasin.getBaseHealthPoints(), hero.HealthPoints());
        Assertions.assertEquals(assasin.getBasePower(), hero.Power());
    }

    @Test
    public void shouldBuildSorcererBaseCharacteristics () {
        hero = heroBuilder.specialty("Sorcerer").basicStats().build();
        SpecialtyCharacteristics sorcerer = SpecialtyCharacteristics.Sorcerer();
        Assertions.assertEquals(sorcerer.getBaseArmour(), hero.Armour());
        Assertions.assertEquals(sorcerer.getBaseHealthPoints(), hero.HealthPoints());
        Assertions.assertEquals(sorcerer.getBasePower(), hero.Power());
    }

    @Test
    public void shouldCreateHeroWithHealthPoints () {
        Integer healthPoints = 30;
        hero = heroBuilder.healthPoints(healthPoints).build();
        Assertions.assertEquals(healthPoints, hero.HealthPoints());
    }

    @Test
    public void shouldThrowForNegativeHealthPoints () {
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
           heroBuilder.healthPoints(-1).build();
       });
    }

    @Test
    public void shouldCreateHeroWithArmour () {
        Integer armour = 30;
        hero = heroBuilder.armour(armour).build();
        Assertions.assertEquals(armour, hero.Armour());
    }

    @Test
    public void shouldThrowForNegativeArmour () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.armour(-1).build();
        });
    }

    @Test
    public void shouldCreateHeroWithPower () {
        Integer power = 30;
        hero = heroBuilder.power(power).build();
        Assertions.assertEquals(power, hero.Power());
    }

    @Test
    public void shouldThrowForNegativePower () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.power(-1).build();
        });
    }

    @Test
    public void shouldCreateHeroWithExperiencePoints () {
        Integer experiencePoints = 30;
        hero = heroBuilder.experiencePoints(experiencePoints).build();
        Assertions.assertEquals(experiencePoints, hero.ExperiencePoints());
    }

    @Test
    public void shouldCreateHeroWithBaseExperiencePoints () {
        hero = heroBuilder.build();
        Assertions.assertEquals(0, hero.ExperiencePoints());
    }

    @Test
    public void shouldThrowForNegativeExperiencePoints () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.experiencePoints(-1).build();
        });
    }

    @Test
    public void shouldCreateHeroWithLevel () {
        Integer level = 10;
        hero = heroBuilder.level(level).build();
        Assertions.assertEquals(level, hero.Level());
    }

    @Test
    public void shouldCreateHeroWithBaseLevel () {
        hero = heroBuilder.build();
        Assertions.assertEquals(1, hero.Level());
    }

    @Test
    public void shouldThrowForZeroLevel () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.level(0).build();
        });
    }

    @Test
    public void shouldThrowForNegativeLevel () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.level(-1).build();
        });
    }

    @Test
    public void shouldCreateHeroWithCommonRarity () {
        hero = heroBuilder.rarity("Common").build();
        Assertions.assertEquals(Rarities.Common, hero.Rarity().value());
    }

    @Test
    public void shouldCreateHeroWithRareRarity () {
        hero = heroBuilder.rarity("Rare").build();
        Assertions.assertEquals(Rarities.Rare, hero.Rarity().value());
    }

    @Test
    public void shouldCreateHeroWithLegendaryRarity () {
        hero = heroBuilder.rarity("Legendary").build();
        Assertions.assertEquals(Rarities.Legendary, hero.Rarity().value());
    }

    @Test
    public void shouldThrowForInvalidRarity () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.rarity("Hello").build();
        });
    }
}
