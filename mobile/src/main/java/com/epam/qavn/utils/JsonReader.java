package com.epam.qavn.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class JsonReader {

    private static JsonReader instance = null;

    public static JsonReader getInstance() {
        if (instance == null) {
            instance = new JsonReader();
        }
        return instance;
    }

    public JsonObject getFromResource(String srcFile, String key) {
        try {
            Gson gson = new Gson();
            URI filePath = Objects.requireNonNull(getClass().getClassLoader().getResource(srcFile)).toURI();
            File jsonFile = Paths.get(filePath).toFile();
            return gson.fromJson(new FileReader(jsonFile), JsonObject.class).getAsJsonObject(key);
        }catch (IOException | URISyntaxException e) {
            return null;
        }
    }
}
