package ecom.qa.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReader {
	public static JSONObject readJson(String filePath) {
        try {
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(new FileReader(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
