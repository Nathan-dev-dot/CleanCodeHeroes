package com.cleancodeheroes.shared.mapper;

import org.bson.Document;

public interface BsonMapper<T> {
    Document doc = new Document() ;

    T toDomain ();
}
