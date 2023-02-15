package com.cleancodeheroes;

import com.cleancodeheroes.card.adapter.out.NoSQLCardPersistence;
import com.cleancodeheroes.card.application.port.in.CreateCardCommand;
import com.cleancodeheroes.card.application.port.in.FindCardQuery;
import com.cleancodeheroes.card.application.port.in.UpdateCardCommand;
import com.cleancodeheroes.card.application.service.CreationCardService;
import com.cleancodeheroes.card.application.service.FinderCardService;
import com.cleancodeheroes.card.application.service.UpdaterCardService;
import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.port.in.CreateHeroCommand;
import com.cleancodeheroes.hero.application.port.in.FindHeroQuery;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroesService;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.adapter.out.NoSQLUserPersistence;
import com.cleancodeheroes.user.application.port.in.CreateUserCommand;
import com.cleancodeheroes.user.application.port.in.FindUserQuery;
import com.cleancodeheroes.user.application.port.in.OpenUserPackCommand;
import com.cleancodeheroes.user.application.port.in.UpdateUserCommand;
import com.cleancodeheroes.user.application.services.CreateUserService;
import com.cleancodeheroes.user.application.services.FindUserService;
import com.cleancodeheroes.user.application.services.OpenerUserPackService;
import com.cleancodeheroes.user.application.services.UpdaterUserService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    private final NoSQLHeroPersistence noSQLHeroPersistence;
    private final CreationHeroService creationHeroUseCase;
    private final FinderHeroService findHeroUseCase;
    private final FinderHeroesService findHeroesUseCase;
    private final OpenerUserPackService openerUserPackService;
    private final NoSQLCardPersistence noSQLCardPersistence;
    private final CreationCardService creationCardUseCase;
    private final UpdaterCardService updaterCardService;
    private final FinderCardService findCardUseCase;
    private final UpdaterUserService updaterUserService;

    private final NoSQLUserPersistence noSQLUserPersistence;
    private final CreateUserService createUserUserCase;
    private final FindUserService findUserUseCase;

    public StartupApplicationListener(
        CommandBus commandBus,
        QueryBus queryBus,

        NoSQLHeroPersistence heroPersistenceAdapter,
        CreationHeroService creationHeroService,
        FinderHeroService finderHeroService,
        FinderHeroesService finderHeroesService,
        OpenerUserPackService openerUserPackService,
        UpdaterUserService updaterUserService,

        NoSQLUserPersistence userPersistenceAdapter,
        CreateUserService createUserUserCase,
        FindUserService findUserUseCase,

        NoSQLCardPersistence cardPersistenceAdapter,
        CreationCardService creationCardService,
        FinderCardService finderCardService,
        UpdaterCardService updaterCardService
    ) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;

        this.noSQLHeroPersistence = heroPersistenceAdapter;
        this.creationHeroUseCase = creationHeroService;
        this.findHeroUseCase = finderHeroService;
        this.findHeroesUseCase = finderHeroesService;
        this.openerUserPackService = openerUserPackService;
        this.updaterUserService = updaterUserService;

        this.noSQLUserPersistence = userPersistenceAdapter;
        this.findUserUseCase = findUserUseCase;
        this.createUserUserCase = createUserUserCase;

        this.noSQLCardPersistence = cardPersistenceAdapter;
        this.creationCardUseCase = creationCardService;
        this.findCardUseCase = finderCardService;
        this.updaterCardService = updaterCardService;
    }

    @Override
    public void onApplicationEvent (ContextRefreshedEvent event){
        commandBus.register(CreateHeroCommand.class, creationHeroUseCase);
        queryBus.register(FindHeroQuery.class, findHeroUseCase);
        queryBus.register(FindHeroesQuery.class, findHeroesUseCase);
        commandBus.register(OpenUserPackCommand.class, openerUserPackService);
        commandBus.register(UpdateUserCommand.class, updaterUserService);

        commandBus.register(CreateUserCommand.class, createUserUserCase);
        queryBus.register(FindUserQuery.class, findUserUseCase);

        commandBus.register(CreateCardCommand.class, creationCardUseCase);
        queryBus.register(FindCardQuery.class, findCardUseCase);
        commandBus.register(UpdateCardCommand.class, updaterCardService);
    }

}