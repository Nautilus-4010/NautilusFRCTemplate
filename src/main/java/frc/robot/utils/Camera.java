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
    private static final String BASE_URL = "http://192.168.1.76"; // Define la URL base como constante
    private final int id;

    public Camera(int id) {
        this.id = id;
    }

    public Map<String, Object> makeHttpRequest(String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            URLConnection connection = url.openConnection();

            try (Reader reader = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(reader)) {

                // Leer todo el contenido de la respuesta
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }

                // Convertir el JSON a un Map
                Gson gson = new Gson();
                return gson.fromJson(result.toString(), new TypeToken<HashMap<String, Object>>() {}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Object> getApriltags() {
        return makeHttpRequest("/apriltags/" + id);
    }

    public Map<String, Object> getObjectDetections() {
        return makeHttpRequest("/models/" + id);
    }
}
