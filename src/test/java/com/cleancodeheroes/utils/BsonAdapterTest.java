package com.cleancodeheroes.utils;

import org.bson.BsonInvalidOperationException;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BsonAdapterTest {

    @Test
    public void shouldCreateBsonAdapter () {
        Document doc = new Document() ;
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertEquals(doc.toBsonDocument(), bsonAdapter.getDocument());
    }

    @Test
    public void shouldGetDocumentString () {
        Document doc = new Document() ;
        doc.append("name", "BsonDocument");
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertEquals("BsonDocument", bsonAdapter.getString("name"));
    }

    @Test
    public void shouldThrowForInvalidDocumentString () {
        Document doc = new Document() ;
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertThrows(BsonInvalidOperationException.class, () -> bsonAdapter.getString("doesNotExist"));
    }

    @Test
    public void shouldGetDocumentInt () {
        Document doc = new Document() ;
        doc.append("integer", 32);
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertEquals(32, bsonAdapter.getInt("integer"));
    }

    @Test
    public void shouldThrowForInvalidDocumentInt () {
        Document doc = new Document() ;
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertThrows(NullPointerException.class, () -> bsonAdapter.getInt("doesNotExist"));
    }

    @Test
    public void shouldGetDocumentObjectId () {
        Document doc = new Document() ;
        ObjectId objectId = new ObjectId();
        doc.append("objectId", objectId);
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertEquals(objectId.toString(), bsonAdapter.getObjectId("objectId"));
    }

    @Test
    public void shouldThrowForInvalidDocumentObjectId () {
        Document doc = new Document() ;
        BsonAdapter bsonAdapter = BsonAdapter.of(doc);

        Assertions.assertThrows(BsonInvalidOperationException.class, () -> bsonAdapter.getObjectId("doesNotExist"));
    }
}
