package co.edu.escuelaing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MicroserviceCall {
    private static List<String> SERVERS_LIST = Arrays.asList("http://localhost:24000", "http://localhost:25000");
    private static int SERVER_INDEX = 0;

    public static String forward(String operation, String value, String lst) throws IOException {
        roundRobin();
        URL obj = new URL(SERVERS_LIST.get(SERVER_INDEX) + "/" + operation + "?list=" + lst + "&value=" + value);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "";
    }

    private static void roundRobin(){
        SERVER_INDEX = (SERVER_INDEX + 1) % SERVERS_LIST.size();
    }
}
