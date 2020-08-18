package com.cheng;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Flattener {

    private static JsonObject flatObj;

    private static void flat(String prefix, JsonObject obj) {
        for(Map.Entry<String, JsonElement> entry: obj.entrySet()) {
            String key = prefix == null ? entry.getKey() : prefix + "." + entry.getKey();
            JsonElement val = entry.getValue();
            if(val.isJsonObject() && !val.getAsJsonObject().isJsonNull()) {
                flat(key, val.getAsJsonObject());
            } else {
                flatObj.add(key, val);
            }
        }
    }

    public static String flat(String json) {
        //get rid of blanks
        json = json.replaceAll("[ \t\n]", "");

        //if empty
        if(json.equals("{}")) return "{}";

        //gson lib will ignore empty json object, replace "{}" with null to deal with it
        json = json.replace("{}", "null");

        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        flatObj = new JsonObject();

        flat(null, obj);
        return flatObj.toString();
    }
}
