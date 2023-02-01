package com.cleancodeheroes.hero.adapter.out;

import com.cleancodeheroes.hero.application.port.out.CreateHeroPort;
import com.cleancodeheroes.hero.application.port.out.FindHeroPort;
import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroId;
import com.cleancodeheroes.hero.domain.HeroProps;
import com.cleancodeheroes.hero.mapper.BsonHeroMapper;
import com.cleancodeheroes.shared.NoSQLRepository;
import com.cleancodeheroes.utils.BsonAdapter;
import com.cleancodeheroes.utils.DocumentUtils;
import com.cleancodeheroes.utils.IdUtils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import lombok.RequiredArgsConstructor;
import org.bson.BsonValue;
import org.bson.Document;

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
        var heroProps = new HeroProps(
                hero.Id(),
                hero.Name(),
                hero.HealthPoints(),
                hero.ExperiencePoints(),
                hero.Power(),
                hero.Armour(),
                hero.Specialty(),
                hero.Rarity(),
                hero.Level()
        );
        final NoSQLHeroPersistenceDTO noSQLHeroPersistenceDTO = new NoSQLHeroPersistenceDTO(heroProps);
        final Document heroDocument = DocumentUtils.documentFromObject(noSQLHeroPersistenceDTO);
        final BsonValue insertedId = registry.insertOne(heroDocument).getInsertedId();
        final String insertedIdStr = IdUtils.fromBsonValueToString(insertedId);
        return HeroId.of(insertedIdStr);
    }

    @Override
    public Hero load(HeroId heroId) {
        var res = registry.find(
                Filters.eq(
                        "_id",
                        IdUtils.fromStringToObjectId(heroId.value())
                )
        );

        return res.map(BsonHeroMapper::toDomain).first();
    }
}
