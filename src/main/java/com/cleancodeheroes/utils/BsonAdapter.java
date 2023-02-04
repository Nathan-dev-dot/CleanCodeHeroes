package com.cleancodeheroes.utils;

import org.bson.BsonDocument;
import org.bson.Document;

final public class BsonAdapter {
    private final BsonDocument document;

    private BsonAdapter(BsonDocument document) {
        this.document = document;
    }

    public static BsonAdapter of (Document doc) {
        return new BsonAdapter(doc.toBsonDocument());
    }


    public String getString (String key) {
        return this.document.getString(key).asString().getValue();
    }

    public int getInt (String key) {
        return this.document.get(key).asInt32().getValue();
    }

    public String getObjectId(String key) {
        return IdUtils.fromObjectIdToString(
                this.document.
                        getObjectId(key).
                        asObjectId().
                        getValue()
        );
    }
}
