package com.cleancodeheroes;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroesService;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final NoSQLHeroPersistence persistenceAdapter;
    private final CreationHeroService createHeroUseCase;
    private final FinderHeroService findHeroUseCase;
    private final FinderHeroesService findHeroesUseCase;

    public StartupApplicationListener(
            CommandBus commandBus,
            QueryBus queryBus,
            NoSQLHeroPersistence persistenceAdapter,
            CreationHeroService createAccountUseCase,
            FinderHeroService finderHeroService,
            FinderHeroesService finderHeroesService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.createHeroUseCase = createAccountUseCase;
        this.findHeroUseCase = finderHeroService;
        this.findHeroesUseCase = finderHeroesService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(CreateHeroCommand.class, createHeroUseCase);
        queryBus.register(FindHeroQuery.class, findHeroUseCase);
        queryBus.register(FindHeroesQuery.class, findHeroesUseCase);
    }
}
