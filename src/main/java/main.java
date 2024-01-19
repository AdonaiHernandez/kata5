import spark.Spark;

public class main {


    public static void main(String[] args) {

        Spark.port(8080);
        Spark.get("/", (req, res) -> "Hola mundo!");
        Spark.get("/factorial", (req, res) -> new CommandExec(req, res).execute(new FactorialCommand()));
    }

    private record CommandExec(spark.Request req, spark.Response res){

        public String execute(Command command){
            Command.Output output = command.execute(input());
            res.status(output.code());
            return output.result();
        }

        public Command.Input input(){
            return new Command.Input() {
                @Override
                public String get(String key) {
                    return req.queryParams(key) == null ? req.params(key) : req.queryParams(key);
                }
            };
        }

    }

}
