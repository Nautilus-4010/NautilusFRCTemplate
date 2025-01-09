package frc.robot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Camera {
    public String makehttprequest(String urlApi){
        try {

            URL url = new URL(urlApi);
            URLConnection connection = url.openConnection();

            Reader r = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(r);
            
            
            return br.readLine();
        } catch (IOException e) {
           return null;
            
        }
    }
}