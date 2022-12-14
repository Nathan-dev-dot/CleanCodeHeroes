package com.cleancodeheroes;

import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.services.CreateHeroService;
import com.cleancodeheroes.hero.application.services.FindHeroService;
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
    private final CreateHeroService createHeroUseCase;
    private final FindHeroService findHeroUseCase;

    public StartupApplicationListener(
            CommandBus commandBus,
            QueryBus queryBus,
            NoSQLHeroPersistence persistenceAdapter,
            CreateHeroService createAccountUseCase,
            FindHeroService findHeroService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.createHeroUseCase = createAccountUseCase;
        this.findHeroUseCase = findHeroService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(CreateHeroCommand.class, createHeroUseCase);
        queryBus.register(FindHeroQuery.class, findHeroUseCase);
    }
}
