package com.cleancodeheroes.hero.application.service;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.in.FindHeroesQuery;
import com.cleancodeheroes.hero.application.port.out.FindHeroesPort;
import com.cleancodeheroes.hero.application.services.FinderHeroesService;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.utils.BsonFilter;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FinderHeroesServiceTest {
    @InjectMocks
    FinderHeroesService finderHeroesService;

    @Mock
    FindHeroesPort findHeroesPort;

    @Mock
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("heroes");

    @Test
    public void shouldReturnAnArrayList(){
        try {
            when(this.findHeroesPort.loadAll()).thenReturn(new ArrayList<>());
            ArrayList<Hero> heroes = this.finderHeroesService.handle(new FindHeroesQuery());
            Assertions.assertEquals(ArrayList.class, heroes.getClass());
        } catch (HeroNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
