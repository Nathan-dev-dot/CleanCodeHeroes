package com.cleancodeheroes.shared.adapter.out;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

public final class NoSQLRepository {

    private static NoSQLRepository INSTANCE ;
    private final MongoClient client ;
    private final MongoDatabase database ;

    private NoSQLRepository () {
        final Dotenv dotenv = Dotenv.configure().load();
        final String username = dotenv.get("DB_USER");
        final String password = dotenv.get("DB_SECRET");
        final String cluster = dotenv.get("DB_CLUSTER");
        final String databaseName = dotenv.get("DB_NAME");
        client = MongoClients.create("mongodb+srv://" + username +
                ":" + password + "@" + cluster + "/?retryWrites=true&w=majority");
        database = client.getDatabase(databaseName);
    }

    public static synchronized NoSQLRepository getInstance () {
        if (INSTANCE == null) {
            INSTANCE = new NoSQLRepository() ;
        }
        return INSTANCE;
    }

    public MongoDatabase getDatabase () {
        return this.database ;
    }

    public static synchronized MongoDatabase getNoSQLDatabase () {
        return NoSQLRepository.getInstance().getDatabase();
    }

}
