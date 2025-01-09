package frc.robot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Camera {
    public Map<String, Object> makeHttpRequest(String urlApi) {
        try {
            URL url = new URL(urlApi);
            URLConnection connection = url.openConnection();

            Reader r = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(r);

            // Read the entire response into a single string
            String result = br.lines().reduce("", (accumulator, actual) -> accumulator + actual);

            // Convert JSON string to Map
            Gson gson = new Gson();
            Map<String, Object> map = gson.fromJson(result, new TypeToken<HashMap<String, Object>>() {}.getType());
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
}