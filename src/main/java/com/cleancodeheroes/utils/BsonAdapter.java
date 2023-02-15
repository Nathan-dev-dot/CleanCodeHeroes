package com.cleancodeheroes.utils;

import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.ArrayList;

public final class BsonAdapter {
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

    public ArrayList<String> getStringObjectIdsArray (String key) {
        ArrayList<String> objectIdsAsStr = new ArrayList<String>();
        BsonArray array = this.document.getArray(key);
        array.getValues().forEach((element) -> {
            objectIdsAsStr.add(element.asObjectId().getValue().toString());
        });
        return objectIdsAsStr;
    }

    public BsonDocument getDocument() {
        return document;
    }
}
