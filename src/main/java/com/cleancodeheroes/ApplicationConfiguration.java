package com.cleancodeheroes;

import com.cleancodeheroes.battle.adapter.out.NoSQLBattlePersistence;
import com.cleancodeheroes.battle.application.service.BattleCreationService;
import com.cleancodeheroes.battle.application.service.FinderBattleByHeroIdService;
import com.cleancodeheroes.battle.application.service.FinderBattleByIdService;
import com.cleancodeheroes.battle.application.service.FinderBattleByUserIdService;
import com.cleancodeheroes.card.adapter.out.NoSQLCardPersistence;
import com.cleancodeheroes.card.application.service.CreationCardService;
import com.cleancodeheroes.card.application.service.FinderCardService;
import com.cleancodeheroes.card.application.service.CardUpdatingService;
import com.cleancodeheroes.card.application.service.UpgraderCardService;
import com.cleancodeheroes.hero.adapter.out.NoSQLHeroPersistence;
import com.cleancodeheroes.hero.application.services.CreationHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroService;
import com.cleancodeheroes.hero.application.services.FinderHeroesService;
import com.cleancodeheroes.kernel.BusFactory;
import com.cleancodeheroes.kernel.command.CommandBus;
import com.cleancodeheroes.kernel.query.QueryBus;
import com.cleancodeheroes.user.adapter.out.NoSQLUserPersistence;
import com.cleancodeheroes.user.application.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }

    @Bean
    public NoSQLHeroPersistence heroPersistenceAdapter() {
        return new NoSQLHeroPersistence();
    }

    @Bean
    public NoSQLUserPersistence userPersistenceAdapter() {
        return new NoSQLUserPersistence();
    }

    @Bean
    public NoSQLCardPersistence cardPersistenceAdapter() {
        return new NoSQLCardPersistence();
    }

    @Bean
    public NoSQLBattlePersistence battlePersistenceAdapter() {
        return new NoSQLBattlePersistence();
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
    public FinderHeroesService finderHeroesUseCase() {
        return new FinderHeroesService(heroPersistenceAdapter());
    }

    @Bean
    public UserCreationService createUserUseCase() {
        return new UserCreationService(userPersistenceAdapter());
    }

    @Bean
    public UserFindingService findUserUseCase() {
        return new UserFindingService(userPersistenceAdapter());
    }

    @Bean
    public UserPackOpeningService openerUserPackService() { return new UserPackOpeningService(); };
    @Bean
    public UserUpdatingService updaterUserService() { return new UserUpdatingService(userPersistenceAdapter()); };
    @Bean
    public UpgraderCardService upgraderCardService() {return new UpgraderCardService(); };

    @Bean
    public UserVictoriesUpdatingService userUpdateVictoriesService () { return new UserVictoriesUpdatingService(); }
    @Bean
    public CreationCardService createCardUseCase () { return new CreationCardService(cardPersistenceAdapter()); }

    @Bean
    public FinderCardService finderCardService () { return new FinderCardService(cardPersistenceAdapter()); }

    @Bean
    public CardUpdatingService updaterCardService () { return new CardUpdatingService(cardPersistenceAdapter()); }


    @Bean
    public FinderBattleByHeroIdService finderBattleByHeroIdService () { return new FinderBattleByHeroIdService(battlePersistenceAdapter()); }

    @Bean
    public FinderBattleByUserIdService finderBattleByUserIdService () { return new FinderBattleByUserIdService(battlePersistenceAdapter()); }

    @Bean
    public FinderBattleByIdService finderBattleByIdService () { return new FinderBattleByIdService(battlePersistenceAdapter()); }

    @Bean
    public BattleCreationService battleCreationService () { return new BattleCreationService(battlePersistenceAdapter()); }


}
