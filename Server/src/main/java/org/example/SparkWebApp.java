package org.example;

import static spark.Spark.*;

/**
 * SparkWeb App end-point service
 */
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        secure("keystores/ecikeystore.p12","123456","keystores/myTrustStore","123456");
        get("/servicio",(request, response) -> "asd");

    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5005;
    }
}
