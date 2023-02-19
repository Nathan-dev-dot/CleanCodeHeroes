package com.cleancodeheroes.utils;

import lombok.val;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DocumentUtilsTest {

    static class TestObject {
        public String property;
        public TestObject (String property) {
            this.property = property;
        }
    }

    @Test
    public void shouldReturnDocumentFromObject () {
        TestObject o = new TestObject("test");
        val document = DocumentUtils.documentFromObject(o);
        Assertions.assertInstanceOf(Document.class, document);
        Assertions.assertEquals("test", document.get("property"));
    }

    @Test
    public void shouldReturnIdFromDocument () {
        ObjectId objectId = new ObjectId();
        Document doc = new Document().append("_id", objectId);
        Assertions.assertEquals(objectId.toString(), DocumentUtils.getIdFromDocument(doc));
    }

    @Test
    public void shouldThrowIfNoIdInDocument () {
        Document doc = new Document();
        Assertions.assertThrows(NullPointerException.class, () -> DocumentUtils.getIdFromDocument(doc));
    }
}
