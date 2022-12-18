package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.shared.NoSQLRepository;
import com.cleancodeheroes.utils.IdUtils;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;

@RequiredArgsConstructor
public class NoSQLHeroPersistence implements FindHeroPort, CreateHeroPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getInstance().getDatabase().getCollection("heroes");
    private static NoSQLHeroPersistence INSTANCE;

    public static synchronized NoSQLHeroPersistence getInstance() {
        if (INSTANCE == null) {
            return new NoSQLHeroPersistence();
        }
        return INSTANCE;
    }
    @Override
    public HeroId save(Hero hero) {
        Gson gson = new Gson() ;
        String heroJSON = gson.toJson(hero);
        Document heroDocument = Document.parse(heroJSON);
        String insertedId = registry.insertOne(heroDocument).getInsertedId().toString();
        return HeroId.of(IdUtils.UUIDFromString(insertedId));
    }

    @Override
    public Hero load(HeroId heroId) {
        registry.find(Filters.eq("_id", new ObjectId(heroId.toString())));
        return null ;
    }
}
