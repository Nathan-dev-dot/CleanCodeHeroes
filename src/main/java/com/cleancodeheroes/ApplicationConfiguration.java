package com.cleancodeheroes;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.kernel.BusFactory;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.adapter.out.NoSQLUserPersistence;
import com.cleancodeheroes.user.application.services.CreateUserService;
import com.cleancodeheroes.user.application.services.FindUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Bean
    public NoSQLHeroPersistence heroPersistenceAdapter() {
        return new NoSQLHeroPersistence();
    }

    @Bean
    public NoSQLUserPersistence userPersistenceAdapter() {
        return new NoSQLUserPersistence();
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
    public CreationHeroService createHeroUseCase() {
        return new CreationHeroService(heroPersistenceAdapter());
    }

    @Bean
    public FinderHeroService findHeroUseCase() {
        return new FinderHeroService(heroPersistenceAdapter());
    }

    @Bean
    public CreateUserService createUserUseCase() {
        return new CreateUserService(userPersistenceAdapter());
    }

    @Bean
    public FindUserService findUserUseCase() {
        return new FindUserService(userPersistenceAdapter());
    }
}
