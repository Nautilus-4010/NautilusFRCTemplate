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

import edu.wpi.first.math.geometry.Transform3d;

public class Camera {
    private static final String BASE_URL = "http://192.168.1.76"; 
    private final int id;

    public final Transform3d positionTorobot;

    public Camera(int id) {
        this.id = id;
        positionTorobot = new Transform3d();
    }

    public Camera(int id, Transform3d positionToRobot) {
        this.id = id;
        this.positionTorobot = positionToRobot;
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
        return makeHttpRequest("/apriltags/" + String.valueOf(id));
    }

    public Map<String, Object> getObject(int modelId) {
            return makeHttpRequest("/models/" + String.valueOf(modelId) + String.valueOf(id));
    }

    public boolean hasApriltags() {
        Map<String, Object> apriltagsData = getApriltags();
    
        if (apriltagsData == null || !apriltagsData.containsKey("detections")) {
            return false; 
        }
    
        Object detections = apriltagsData.get("detections");
    
        if (detections instanceof Number) {
            return ((Number) detections).intValue() > 0;
        }
    
        return false; 
    }
    
    public boolean hasObjects(int modelId) {
        Map<String, Object> modelData = getObject(modelId);
    
        if (modelData == null || !modelData.containsKey("detections")) {
            return false; 
        }
    
        Object detections = modelData.get("detections");
    
        if (detections instanceof Number) {
            return ((Number) detections).intValue() > 0;
        }
    
        return false; 
    }
    
}
