import java.util.stream.LongStream;

public class FactorialCommand implements Command{

    public Output execute(Input input){
        try {
            return factorial(input.get("number"));

        } catch (NumberFormatException e){
            return Command.output(null, 500);
        }
    }

    private Output factorial(String num){

        int number = Integer.parseInt(num);

        if (number > 15) return Command.output(null, 500);

        Long res = LongStream.range(1, number+1).reduce(1, (i,a) -> i*a);

        return Command.output(res.toString(), 200);
    }

}
