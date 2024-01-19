public interface Command {

    Output execute(Input input);

    interface Output{
        String result();

        int code();
    }

    interface Input{
        String get(String key);
    }

    static Output output(String res, int code){

        return new Output() {
            @Override
            public String result() {
                return res;
            }

            @Override
            public int code() {
                return code;
            }
        };

    }

}
