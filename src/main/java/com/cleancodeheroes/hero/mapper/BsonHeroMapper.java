package com.cleancodeheroes.hero.mapper;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

public class BsonHeroMapper {
    public static Hero toDomain(Document doc){
        BsonAdapter heroAdapter = BsonAdapter.of(doc);
        return new HeroBuilder()
                .id(heroAdapter.getObjectId("_id"))
                .name(heroAdapter.getString("name"))
                .rarity(heroAdapter.getString("rarity"))
                .specialty(heroAdapter.getString("specialty"))
                .healthPoints(heroAdapter.getInt("healthPoints"))
                .experiencePoints(heroAdapter.getInt("experiencePoints"))
                .power(heroAdapter.getInt("power"))
                .armour(heroAdapter.getInt("armour"))
                .level(heroAdapter.getInt("level"))
                .build();
    }
}

