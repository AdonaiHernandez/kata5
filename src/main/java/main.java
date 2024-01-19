import spark.Spark;

public class main {


    public static void main(String[] args) {

        Spark.port(8080);
        Spark.get("/", (req, res) -> "Hola mundo!");
    }

}
