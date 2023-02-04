package com.cleancodeheroes;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.services.CreateHeroService;
import com.cleancodeheroes.hero.application.services.FindHeroService;
import com.cleancodeheroes.kernel.BusFactory;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Bean
    public NoSQLHeroPersistence persistenceAdapter() {
        return new NoSQLHeroPersistence();
    }

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }

    @Bean
    public CreateHeroService createHeroUseCase() {
        return new CreateHeroService(persistenceAdapter());
    }

    @Bean
    public FindHeroService findHeroUseCase() {
        return new FindHeroService(persistenceAdapter());
    }
}
