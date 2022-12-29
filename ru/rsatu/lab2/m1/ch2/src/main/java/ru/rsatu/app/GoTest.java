package main.java.ru.rsatu.app;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class GoTest {
    public static JSONObject stringToJson(String s) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(s);
            return json;
        } catch (Exception e) {
            return null;
        }
    }

    public static String jsonToString(JSONObject jsonObject) {
        return jsonObject.toString();
    }
}

