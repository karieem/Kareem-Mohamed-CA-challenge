package com.petfinder.crowdanalyzer.utils.files;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private static JsonPath jsonPath;
    private static FileReader fileReader;

    /**
     * Constructor to load properties from the given relative path.
     *
     * @param relativePath the relative path to the properties file
     * @throws IOException if the file is not found or cannot be read
     */
    public JsonReader(String relativePath) {
        try {
            fileReader = new FileReader(new File(relativePath).getAbsolutePath());
            jsonPath = JsonPath.from(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the value of a JSON key.
     *
     * @param jsonPathKey the jsonPath of the value
     * @return the value of the jsonPath, or null if the value does not exist
     */
    public static String getJson(String jsonPathKey) {
        return jsonPath.getString(jsonPathKey);
    }
}
