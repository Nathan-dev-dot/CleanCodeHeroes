package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.application.HeroNotFoundException;
import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroesByRarityPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroesPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.hero.mapper.BsonHeroMapper;
import com.cleancodeheroes.shared.adapter.out.NoSQLRepository;
import com.cleancodeheroes.shared.domain.Rarity;
import com.cleancodeheroes.utils.BsonFilter;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.RequiredArgsConstructor;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.ArrayList;

@RequiredArgsConstructor
public final class NoSQLHeroPersistence implements FindHeroPort, FindHeroesPort, FindHeroesByRarityPort, CreateHeroPort {
    private final MongoCollection<Document> registry = NoSQLRepository.getNoSQLDatabase().getCollection("heroes");

    @Override
    public HeroId save(Hero hero) {
        final NoSQLHeroPersistenceDTO noSQLHeroPersistenceDTO = new NoSQLHeroPersistenceDTO(hero);
        final Document heroDocument = DocumentUtils.documentFromObject(noSQLHeroPersistenceDTO);
        final BsonValue insertedId = registry.insertOne(heroDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return HeroId.of(insertedIdStr);
    }

    @Override
    public Hero load (HeroId heroId) throws HeroNotFoundException {
        var res = registry.find(
                new BsonFilter(heroId.value()).filter
        );
        if (DocumentUtils.sizeof(res) == 0) throw new HeroNotFoundException();
        return res.map(doc -> new BsonHeroMapper(doc).toDomain()).first();
    }

    @Override
    public ArrayList<Hero> loadAll () throws HeroNotFoundException {
        var res = registry.find();
        if (DocumentUtils.sizeof(res) == 0) throw new HeroNotFoundException();
        return res.map(doc -> new BsonHeroMapper(doc).toDomain()).into(new ArrayList<>());
    }


    @Override
    public ArrayList<Hero> loadAllByRarity(Rarity rarity) throws HeroNotFoundException {
        var res = registry.find(Filters.eq(
                "rarity",
                rarity.value().toString()
        ));
        if (DocumentUtils.sizeof(res) == 0) throw new HeroNotFoundException();
        return res.map(doc -> new BsonHeroMapper(doc).toDomain()).into(new ArrayList<>());
    }
}
