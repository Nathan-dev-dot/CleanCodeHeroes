package com.cleancodeheroes;

import com.cleancodeheroes.card.adapter.out.NoSQLCardPersistence;
import com.cleancodeheroes.card.application.service.CreationCardService;
import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroesService;
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
    public CreationHeroService createAccountUseCase() {
        return new CreationHeroService(persistenceAdapter());
    }

    @Bean
    public FinderHeroService sendMoneyUseCase() {
        return new FinderHeroService(persistenceAdapter());
    }

    @Bean
    public FinderHeroesService createHeroesUseCase() {
        return new FinderHeroesService(persistenceAdapter());
    }

    @Bean
    public NoSQLCardPersistence cardPersistenceAdapter() {
        return new NoSQLCardPersistence();
    }

    @Bean
    public CreationCardService createHeroUseCase () { return new CreationCardService(cardPersistenceAdapter()); }
}
