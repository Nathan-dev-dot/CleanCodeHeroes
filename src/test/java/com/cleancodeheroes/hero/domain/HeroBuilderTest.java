package com.cleancodeheroes.hero.domain;

import com.cleancodeheroes.shared.domain.Rarities;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.shared.domain.SpecialtyCharacteristics;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.MissingResourceException;

public final class HeroBuilderTest {
    private HeroBuilder heroBuilder = new HeroBuilder();
    Hero hero;

    @BeforeEach
    public void shouldInitBuilder () {
        heroBuilder = new HeroBuilder() ;
    }

    @Test
    public void shouldCreateHeroWithRandomId () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build();
        Assertions.assertNotNull(hero.Id());
    }

    @Test
    public void shouldCreateHeroWithGivenId () {
        ObjectId id = new ObjectId();
        hero = heroBuilder
                .id(id.toString())
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build();
        Assertions.assertEquals(id.toString(), hero.Id().value());
    }

    @Test
    public void shouldThrowForInvalidGivenId () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.id("azerty");
        });
    }

    @Test
    public void shouldBuildHeroWithName () {
        String name = "Hero";
        hero = heroBuilder
                .id()
                .name(name)
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build();
        Assertions.assertEquals(name, hero.Name());
    }

    @Test
    public void shouldThrowForHeroNameEmpty () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.name("");
        });
    }

    @Test
    public void shouldThrowForInvalidSpecialty () {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            heroBuilder.specialty("Specialty") ;
        });
    }

    @Test
    public void shouldBuildTank () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build() ;
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
    }

    @Test
    public void shouldBuildAssassin () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Assassin")
                .basicStats()
                .build() ;
        Assertions.assertEquals(CharacterType.Assassin, hero.Specialty().value());
    }

    @Test
    public void shouldBuildSorcerer () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Sorcerer")
                .basicStats()
                .build() ;
        Assertions.assertEquals(CharacterType.Sorcerer, hero.Specialty().value());
    }

    @Test
    public void shouldThrowForBasicStatsIfNoSpecialty () {
        HeroBuilder heroBuilder = new HeroBuilder();
        Assertions.assertThrows(MissingResourceException.class, heroBuilder::basicStats);
    }

    @Test
    public void shouldThrowForBasicStatsIfNoRarity () {
        HeroBuilder heroBuilder = new HeroBuilder();
        Assertions.assertThrows(MissingResourceException.class, () ->{
            heroBuilder.specialty("Tank").basicStats();
        });
    }

    @Test
    public void shouldBuildCommonTankBaseCharacteristics () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build();
        SpecialtyCharacteristics tank = SpecialtyCharacteristics.Tank();
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
        Assertions.assertEquals(tank.getBaseArmour(), hero.Armour().value());
        Assertions.assertEquals(tank.getBaseHealthPoints(), hero.HealthPoints().value());
        Assertions.assertEquals(tank.getBasePower(), hero.Power().value());
    }

    @Test
    public void shouldBuildCommonAssassinBaseCharacteristics () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Assassin")
                .basicStats()
                .build();
        SpecialtyCharacteristics assasin = SpecialtyCharacteristics.Assassin();
        Assertions.assertEquals(assasin.getBaseArmour(), hero.Armour().value());
        Assertions.assertEquals(assasin.getBaseHealthPoints(), hero.HealthPoints().value());
        Assertions.assertEquals(assasin.getBasePower(), hero.Power().value());
    }

    @Test
    public void shouldBuildCommonSorcererBaseCharacteristics () {
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Sorcerer")
                .basicStats()
                .build();
        SpecialtyCharacteristics sorcerer = SpecialtyCharacteristics.Sorcerer();
        Assertions.assertEquals(sorcerer.getBaseArmour(), hero.Armour().value());
        Assertions.assertEquals(sorcerer.getBaseHealthPoints(), hero.HealthPoints().value());
        Assertions.assertEquals(sorcerer.getBasePower(), hero.Power().value());
    }

    @Test
    public void shouldBuildRareTankBaseCharacteristics () {
        double rareIncreaseFactor = new Rarity("Rare").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Tank")
                .basicStats()
                .build();
        SpecialtyCharacteristics tank = SpecialtyCharacteristics.Tank();
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
        Assertions.assertEquals((int) (tank.getBaseArmour() * rareIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (tank.getBaseHealthPoints() * rareIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (tank.getBasePower() * rareIncreaseFactor), hero.Power().value());
    }

    @Test
    public void shouldBuildRareAssassinBaseCharacteristics () {
        double rareIncreaseFactor = new Rarity("Rare").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Assassin")
                .basicStats()
                .build();
        SpecialtyCharacteristics assasin = SpecialtyCharacteristics.Assassin();
        Assertions.assertEquals((int) (assasin.getBaseArmour() * rareIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (assasin.getBaseHealthPoints() * rareIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (assasin.getBasePower() * rareIncreaseFactor), hero.Power().value());
    }

    @Test
    public void shouldBuildRareSorcererBaseCharacteristics () {
        double rareIncreaseFactor = new Rarity("Rare").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Sorcerer")
                .basicStats()
                .build();
        SpecialtyCharacteristics sorcerer = SpecialtyCharacteristics.Sorcerer();
        Assertions.assertEquals((int) (sorcerer.getBaseArmour() * rareIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (sorcerer.getBaseHealthPoints() * rareIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (sorcerer.getBasePower() * rareIncreaseFactor), hero.Power().value());
    }

    @Test
    public void shouldBuildLegendaryTankBaseCharacteristics () {
        double legendaryIncreaseFactor = new Rarity("Legendary").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Tank")
                .basicStats()
                .build();
        SpecialtyCharacteristics tank = SpecialtyCharacteristics.Tank();
        Assertions.assertEquals(CharacterType.Tank, hero.Specialty().value());
        Assertions.assertEquals((int) (tank.getBaseArmour() * legendaryIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (tank.getBaseHealthPoints() * legendaryIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (tank.getBasePower() * legendaryIncreaseFactor), hero.Power().value());
    }

    @Test
    public void shouldBuildLegendaryAssassinBaseCharacteristics () {
        double legendaryIncreaseFactor = new Rarity("Legendary").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Assassin")
                .basicStats()
                .build();
        SpecialtyCharacteristics assasin = SpecialtyCharacteristics.Assassin();
        Assertions.assertEquals((int) (assasin.getBaseArmour() * legendaryIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (assasin.getBaseHealthPoints() * legendaryIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (assasin.getBasePower() * legendaryIncreaseFactor), hero.Power().value());
    }

    @Test
    public void shouldBuildLegendarySorcererBaseCharacteristics () {
        double legendaryIncreaseFactor = new Rarity("Legendary").baseIncreaseFactor();
        hero = heroBuilder
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Sorcerer")
                .basicStats()
                .build();
        SpecialtyCharacteristics sorcerer = SpecialtyCharacteristics.Sorcerer();
        Assertions.assertEquals((int) (sorcerer.getBaseArmour() * legendaryIncreaseFactor), hero.Armour().value());
        Assertions.assertEquals((int) (sorcerer.getBaseHealthPoints() * legendaryIncreaseFactor), hero.HealthPoints().value());
        Assertions.assertEquals((int) (sorcerer.getBasePower() * legendaryIncreaseFactor), hero.Power().value());
    }


    @Test
    public void shouldCreateHeroWithCommonRarity () {
        hero = heroBuilder
                .id()
                .name("Test")
                .specialty("Tank")
                .rarity("Common")
                .basicStats()
                .build();
        Assertions.assertEquals(Rarities.Common, hero.Rarity().value());
    }

    @Test
    public void shouldCreateHeroWithRareRarity () {
        hero = heroBuilder
                .id()
                .name("Test")
                .specialty("Tank")
                .rarity("Rare")
                .basicStats()
                .build();
        Assertions.assertEquals(Rarities.Rare, hero.Rarity().value());
    }

    @Test
    public void shouldCreateHeroWithLegendaryRarity () {
        hero = heroBuilder
                .id()
                .name("Test")
                .specialty("Tank")
                .rarity("Legendary")
                .basicStats()
                .build();
        Assertions.assertEquals(Rarities.Legendary, hero.Rarity().value());
    }

    @Test
    public void shouldThrowForInvalidRarity () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            heroBuilder.rarity("Hello");
        });
    }
}
