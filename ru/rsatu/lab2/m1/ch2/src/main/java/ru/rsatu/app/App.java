package ru.rsatu.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main( String[] args ) {
        JSONObject obj = new JSONObject();
        obj.put("name", "test");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("1");
        list.add("2");
        list.add("3");

        obj.put("messages", list);

        System.out.println(obj);
    }
}
