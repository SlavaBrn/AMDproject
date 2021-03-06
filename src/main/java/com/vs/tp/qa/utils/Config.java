package com.vs.tp.qa.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Config {
    private String Environment = "dev";
    private Boolean IsE2e = false;
    private String Browser = "chrome";
    private Boolean IsHeadless = false; 

    public Config() {
        JSONObject settings = ReadAndParseJson("settings.json");
        if (settings != null) {
            Environment = (String) settings.get("environment");
            IsE2e = (Boolean) settings.get("isE2e");
            Browser = (String) settings.get("browser");
            IsHeadless = (Boolean) settings.get("isHeadless");
        }
    }

    public String GetEnvironment() {
        return Environment;
    }

    public String GetBrowser() {
        return Browser;
    }

    public Boolean GetIsHeadless() {
        return IsHeadless;
    }

    public Boolean GetIsE2e() {
        return IsE2e;
    }

    private JSONObject ReadAndParseJson(String file) {
        JSONParser parser = new JSONParser();
        JSONObject settings = null;

        try (Reader reader = new FileReader(file)) {
            settings = (JSONObject) parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return settings;
    }
}
