package edu.swarthmore.cs.cmarsh1.maproute.utils;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;

import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Secrets {
    private static String apiKey;

    private static void readJsonFromFile() {
        try {
            JSONObject jsonObj = new JSONObject(new String(readAllBytes(get("src/main/resources/secrets.json"))));
            apiKey = jsonObj.getString("googleMapsKey");
        } catch (IOException e) {
            System.out.println("Could not find the secrets file");
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        if(apiKey == null){
            readJsonFromFile();
        }

        return apiKey;
    }
}