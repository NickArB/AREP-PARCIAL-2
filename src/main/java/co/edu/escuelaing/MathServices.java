package co.edu.escuelaing;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class MathServices{
    public static void main( String[] args ){
        port(getPort());
        get("linearSearch", (req,res) -> {
            String value = req.queryParams("value");
            String lst = req.queryParams("list");
            List<Integer> lstInt = new ArrayList<>();
            List<String> lstString = Arrays.asList(lst.split(",")); 
            for (String s: lstString){
                lstInt.add(Integer.parseInt(s));
            }
            Integer ans = SearchAlgorithms.linearSearch(lstInt, Integer.parseInt(value));
            return toJSON(lst, value, "linearSearch", ans); 
        });
        get("binarySearch", (req,res) -> {
            String value = req.queryParams("value");
            String lst = req.queryParams("list");
            List<Integer> lstInt = new ArrayList<>();
            List<String> lstString = Arrays.asList(lst.split(",")); 
            for (String s: lstString){
                lstInt.add(Integer.parseInt(s));
            }
            Integer ans = SearchAlgorithms.binarySearch(lstInt, Integer.parseInt(value));
            return toJSON(lst, value, "binarySearch", ans);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 25000;
    }

    private static String toJSON(String numbers, String value, String operation, int ans){
        return "{\"operation\":\"" + operation + "\",\"inputList\":\"" + numbers + "\",\"value\":\"" + value + "\",\"output\":\"" + ans + "\"}";
    }
}

// {
//     "operation": "binarySearch",
//     "inputlist": "10,20,13,40,60",
//     "value": "13"
//     "output":  "2"
//    }
