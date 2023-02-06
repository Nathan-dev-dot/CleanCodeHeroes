package com.cleancodeheroes.shared.adapter.out;

import com.mongodb.client.MongoDatabase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public final class NoSQLRepositoryTest {

    @Test
    public void shouldGetRepositoryInstance () {
        final NoSQLRepository repository = NoSQLRepository.getInstance() ;
        Assertions.assertNotNull(repository);
    }

    @Test
    public void shouldNotInstanciateRepositoryTwice () {
        final NoSQLRepository firstRepository = NoSQLRepository.getInstance() ;
        final NoSQLRepository secondRepository = NoSQLRepository.getInstance() ;
        Assertions.assertEquals(firstRepository, secondRepository);
    }

    @Test
    public void shouldGetDatabaseFromInstance () {
        final NoSQLRepository repository = NoSQLRepository.getInstance() ;
        final MongoDatabase database = repository.getDatabase() ;
        Assertions.assertEquals("CleanCodeHeroes", database.getName());
    }

    @Test
    public void shouldGetDatabase () {
        final MongoDatabase database = NoSQLRepository.getNoSQLDatabase();
        Assertions.assertEquals("CleanCodeHeroes", database.getName());
    }
}
