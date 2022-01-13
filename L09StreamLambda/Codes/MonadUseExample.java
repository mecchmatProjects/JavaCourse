

import LogMonad;


public class MonadUseExample {


    private static final Logger LOGGER = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {

        String value = "5";
        Function<String, LogMonad<Integer>> hashCodeMonadic =
          input -> LogMonad.of(input.hashCode());
        Function<Integer, LogMonad<List<Integer>>> toListMonadic = 
          input -> LogMonad.of(List.of(input));
         LogMonad.of(value)
                .flatMap(hashCodeMonadic)
                .log()
                .flatMap(toListMonadic)
                .log(Level.WARNING);
        Function<String, Integer> hashCode = String::hashCode;
        Function<Integer, List<Integer>> toList = List::of;
        Integer valueHashCode = hashCode.apply(value);

        LOGGER.info(valueHashCode.toString());
        List<Integer> hashCodeList = toList.apply(valueHashCode);
        LOGGER.log(Level.WARNING, "{0}", hashCodeList);

    }

}

