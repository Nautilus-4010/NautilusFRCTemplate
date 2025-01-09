
public class Camera {
    public String makehttprequest(String urlApi){

        return ;
        try {

            URL url = new URL(urlApi);
            URLConnection connection = url.openConnection();

            Reader r = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(r);
            
            
            return br.readLine()
        } catch (IOException e) {
           return null;
            
        }
    }
}