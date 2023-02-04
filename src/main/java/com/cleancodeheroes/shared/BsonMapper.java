package com.cleancodeheroes.shared;

import org.bson.Document;

public interface BsonMapper<T> {
    Document doc = new Document() ;

    T toDomain ();
}
