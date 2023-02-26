package com.cleancodeheroes.user.service;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.services.OpenerUserPackService;
import com.cleancodeheroes.user.domain.PackType;
import com.cleancodeheroes.utils.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpenerUserPackServiceTest {
    @InjectMocks
    OpenerUserPackService openerUserPackService;

    @Mock
    Random random;

    @Test
    public void shouldReturnCommonRarityForSilverPack () {
        PackType silverPack = PackType.Silver;
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        Hero commonHero = new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build();
        heroes.add(commonHero);
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Tank")
                .basicStats()
                .build());
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Tank")
                .basicStats()
                .build());
        lenient().when(random.value()).thenReturn(0.95);
        lenient().when(random.intvalue()).thenReturn(50);
        ArrayList<Hero> expected = new ArrayList<>();
        expected.add(commonHero);
        expected.add(commonHero);
        expected.add(commonHero);
        ArrayList<Hero> actual = this.openerUserPackService.handle(new OpenUserPackCommand(silverPack, heroes));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRareRarityForSilverPack () {
        PackType silverPack = PackType.Silver;
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        Hero rareHero = new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Tank")
                .basicStats()
                .build();
        heroes.add(rareHero);
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build());
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Tank")
                .basicStats()
                .build());
        when(random.value()).thenReturn(0.20);
        when(random.intvalue()).thenReturn(50);
        ArrayList<Hero> expected = new ArrayList<>();
        expected.add(rareHero);
        expected.add(rareHero);
        expected.add(rareHero);
        ArrayList<Hero> actual = this.openerUserPackService.handle(new OpenUserPackCommand(silverPack, heroes));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLegendaryRarityForSilverPack () {
        PackType silverPack = PackType.Silver;
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        Hero legendaryHero = new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Legendary")
                .specialty("Tank")
                .basicStats()
                .build();
        heroes.add(legendaryHero);
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Common")
                .specialty("Tank")
                .basicStats()
                .build());
        heroes.add(new HeroBuilder()
                .id()
                .name("Test")
                .rarity("Rare")
                .specialty("Tank")
                .basicStats()
                .build());
        when(random.value()).thenReturn(0.01);
        when(random.intvalue()).thenReturn(50);
        ArrayList<Hero> expected = new ArrayList<>();
        expected.add(legendaryHero);
        expected.add(legendaryHero);
        expected.add(legendaryHero);
        ArrayList<Hero> actual = this.openerUserPackService.handle(new OpenUserPackCommand(silverPack, heroes));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIfNoCommonCardsAvailable () {
        when(random.value()).thenReturn(0.95);
        PackType silverPack = PackType.Silver;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.openerUserPackService.handle(new OpenUserPackCommand(
                        silverPack,
                        new ArrayList<Hero>()
                ))
        );
    }

    @Test
    public void shouldThrowIfNoRareCardsAvailable () {
        when(random.value()).thenReturn(0.20);
        PackType silverPack = PackType.Silver;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.openerUserPackService.handle(new OpenUserPackCommand(
                        silverPack,
                        new ArrayList<Hero>()
                ))
        );
    }

    @Test
    public void shouldThrowIfNoLegendaryCardsAvailable () {
        when(random.value()).thenReturn(0.01);
        PackType silverPack = PackType.Silver;
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> this.openerUserPackService.handle(new OpenUserPackCommand(
                        silverPack,
                        new ArrayList<Hero>()
                ))
        );
    }
}
