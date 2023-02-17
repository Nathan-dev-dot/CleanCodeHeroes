package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.shared.domain.Rarities;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.OpenUserPackUseCase;
import com.cleancodeheroes.user.domain.PackCharacteristics;
import com.cleancodeheroes.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class OpenerUserPackService implements OpenUserPackUseCase {

    @Override
    public ArrayList<Hero> handle(OpenUserPackCommand command) throws IllegalArgumentException {
        PackCharacteristics packCharacteristics = PackCharacteristics.of(command.packType);
        ArrayList<Hero> randomlyPulledHeroes = new ArrayList<Hero>();
        for (var i = 0 ; i < packCharacteristics.getNumberOfCards() ; ++i) {
            var cardRarity = getRandomRarityFromPackCharacteristics(packCharacteristics);
            var rarityHeroes = command.heroes.stream().filter(
                    (hero) -> hero.Rarity().value() == cardRarity
            ).toList();
            randomlyPulledHeroes.add(0, this.selectRandomHeroFromList(rarityHeroes));
        }
        return randomlyPulledHeroes;
    }

    private Hero selectRandomHeroFromList(List<Hero> heroes) {
        var randomHeroIndex = RandomUtils.randomToInt() % heroes.size();
        return heroes.get(randomHeroIndex);
    }

    private Rarities getRandomRarityFromPackCharacteristics (PackCharacteristics packCharacteristics) {
        double probability = RandomUtils.random();
        Rarities cardRarity;
        if (probability <= packCharacteristics.getLegendaryDropPercentage()) {
            cardRarity = Rarities.Legendary;
        } else if (probability <= packCharacteristics.getRareDropPercentage()) {
            cardRarity = Rarities.Rare;
        } else {
            cardRarity = Rarities.Common;
        }
        return cardRarity;
    }
}
