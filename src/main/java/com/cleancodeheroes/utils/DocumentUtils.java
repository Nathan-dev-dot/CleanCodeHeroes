package com.cleancodeheroes.utils;

import com.google.gson.Gson;
import org.bson.Document;

public class DocumentUtils {

    public static Document documentFromObject (Object object) {
        final Gson gson = new Gson() ;
        final String objectAsJsonStr = gson.toJson(object);
        return Document.parse(objectAsJsonStr);
    }
}
