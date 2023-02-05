package com.cleancodeheroes.hero.mapper;

import com.cleancodeheroes.hero.domain.Hero;
import com.cleancodeheroes.hero.domain.HeroBuilder;
import com.cleancodeheroes.shared.mapper.BsonMapper;
import com.cleancodeheroes.utils.BsonAdapter;
import org.bson.Document;

public class BsonHeroMapper implements BsonMapper<Hero> {
    private Document doc;

    public BsonHeroMapper (Document doc) { this.doc = doc; }


    public Hero toDomain(){
        BsonAdapter heroAdapter = BsonAdapter.of(this.doc);
        return new HeroBuilder()
                .id(heroAdapter.getObjectId("_id"))
                .name(heroAdapter.getString("name"))
                .rarity(heroAdapter.getString("rarity"))
                .specialty(heroAdapter.getString("specialty"))
                .healthPoints(heroAdapter.getInt("healthPoints"))
                .power(heroAdapter.getInt("power"))
                .armour(heroAdapter.getInt("armour"))
                .build();
    }
}

