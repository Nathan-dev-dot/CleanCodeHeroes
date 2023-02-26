package com.cleancodeheroes.user.application.services;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.shared.domain.Rarities;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.OpenUserPackUseCase;
import com.cleancodeheroes.user.domain.PackCharacteristics;
import com.cleancodeheroes.utils.Random;

import java.util.ArrayList;
import java.util.List;

public class UserPackOpeningService implements OpenUserPackUseCase {
    private Random random = new Random();

    @Override
    public ArrayList<Hero> handle(OpenUserPackCommand command) throws IllegalArgumentException {
        PackCharacteristics packCharacteristics = PackCharacteristics.of(command.packType);
        ArrayList<Hero> randomlyPulledHeroes = new ArrayList<Hero>();
        for (var i = 0 ; i < packCharacteristics.getNumberOfCards() ; ++i) {
            var cardRarity = getRandomRarityFromPackCharacteristics(packCharacteristics);
            var rarityHeroes = command.heroes.stream().filter(
                    (hero) -> hero.Rarity().value() == cardRarity
            ).toList();
            if (rarityHeroes.size() == 0) throw new IllegalArgumentException();
            randomlyPulledHeroes.add(0, this.selectRandomHeroFromList(rarityHeroes));
        }
        return randomlyPulledHeroes;
    }

    private Hero selectRandomHeroFromList(List<Hero> heroes) {
        this.random.run();
        var randomHeroIndex = this.random.intvalue() % heroes.size();
        return heroes.get(randomHeroIndex);
    }

    private Rarities getRandomRarityFromPackCharacteristics (PackCharacteristics packCharacteristics) {
        this.random.run();
        double probability = random.value();
        Rarities cardRarity;
        if (probability < packCharacteristics.getLegendaryDropPercentage()) {
            cardRarity = Rarities.Legendary;
        } else if (probability < packCharacteristics.getLegendaryDropPercentage() + packCharacteristics.getRareDropPercentage()) {
            cardRarity = Rarities.Rare;
        } else {
            cardRarity = Rarities.Common;
        }
        return cardRarity;
    }
}
