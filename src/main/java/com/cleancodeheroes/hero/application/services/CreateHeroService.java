package com.cleancodeheroes.hero.application.services;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.CreateHeroUseCase;
import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import org.bson.types.ObjectId;

public class CreateHeroService implements CreateHeroUseCase {

    private final CreateHeroPort createHeroPort;

    public CreateHeroService(CreateHeroPort createHeroPort) {
        this.createHeroPort = createHeroPort;
    }

    @Override
    public HeroId handle(CreateHeroCommand command) {
        var heroId = new ObjectId();
        Hero hero = new HeroBuilder()
                .id(heroId.toString())
                .specialty(command.getSpecialty())
                .basicStats()
                .rarity(command.getRarity())
                .name(command.getName())
                .build();
        return this.createHeroPort.save(hero);
    }
}
