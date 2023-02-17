package com.cleancodeheroes.utils;

import lombok.val;
import org.bson.Document;
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
}
