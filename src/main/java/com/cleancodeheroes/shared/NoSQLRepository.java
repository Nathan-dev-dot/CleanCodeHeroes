package com.cleancodeheroes.shared;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

public final class NoSQLRepository {

    private static NoSQLRepository INSTANCE ;
    private final MongoClient client ;
    private final MongoDatabase database ;

    private NoSQLRepository () {
        Dotenv dotenv = Dotenv.configure().load();
        String username = dotenv.get("DB_USER");
        String password = dotenv.get("DB_SECRET");
        String cluster = dotenv.get("DB_CLUSTER");
        String databaseName = dotenv.get("DB_NAME");
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
}
