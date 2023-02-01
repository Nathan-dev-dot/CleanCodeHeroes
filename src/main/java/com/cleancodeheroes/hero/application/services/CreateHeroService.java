package com.cleancodeheroes.hero.application.services;

import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.CreateHeroUseCase;
import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.UUID;


public class CreateHeroService implements CreateHeroUseCase {

    private final CreateHeroPort createHeroPort;

    public CreateHeroService(CreateHeroPort createHeroPort) {
        this.createHeroPort = createHeroPort;
    }

    @Override
    public HeroId handle(CreateHeroCommand command) {
        var heroId = IdUtils.newUUID();
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
