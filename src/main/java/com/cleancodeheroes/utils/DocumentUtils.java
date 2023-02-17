package com.cleancodeheroes.utils;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.ArrayList;

public final class DocumentUtils {

    public static Document documentFromObject (Object object) {
        final Gson gson = new Gson() ;
        final String objectAsJsonStr = gson.toJson(object);
        return Document.parse(objectAsJsonStr);
    }

    public static Integer sizeof (FindIterable<Document> res) {
        return res.into(new ArrayList<>()).size();
    }

    public static String getIdFromDocument (Document d) throws NullPointerException {
        return d.getObjectId("_id").toString();
    }
}
