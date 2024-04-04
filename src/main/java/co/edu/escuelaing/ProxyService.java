package co.edu.escuelaing;
import static spark.Spark.*;

public class ProxyService {
    public static void main(String[] args) {
        port(getPort());
        get("linearSearch", (req,res) -> {
            String value = req.queryParams("value");
            String lst = req.queryParams("list");
            return MicroserviceCall.forward("linearSearch", value, lst);
        });

        get("binarySearch", (req,res) -> {
            String value = req.queryParams("value");
            String lst = req.queryParams("list");
            return MicroserviceCall.forward("binarySearch", value, lst);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 26000;
    }
}
