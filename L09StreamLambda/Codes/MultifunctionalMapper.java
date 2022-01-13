import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class MultifunctionalMapper {

    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
          {
		 (x) ->  //List<IntUnaryOperator>
			{
				return (lst) -> {
				
					for(IntUnaryOperator f: x){
						f.apply(lst);
														
					}
				}
				
			}
		
	}

    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     *
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list. 
     * It multiplies by two each integer number and then add one to its.
     * 
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> 2*x, x -> x+1, x -> x));
    /**
     * The operator accepts an integer list. 
     * It squares each integer number and then get the next even number following it.
     * 
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x*x, x -> x+(x%2==0)?2:1, x -> x));

    // Please, do not change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> idMapper = multifunctionalMapper
                .apply(Arrays.asList(x -> x, x -> x, x -> x))
                .apply(numbers);

        List<Integer> idTransfomarmation =
                identityTransformation.apply(numbers);

        List<Integer> mult2AndAdd1Mapper = multifunctionalMapper
                .apply(Arrays.asList(x -> x * 2, x -> x + 1))
                .apply(numbers);

        List<Integer> mult2AndAdd1Tranformation =
                multTwoAndThenAddOneTransformation.apply(numbers);

        List<Integer> squareAndNextEvenMapper = multifunctionalMapper
                .apply(Arrays.asList(x -> x * x, x -> x % 2 == 0 ? x + 2 : x + 1))
                .apply(numbers);

        List<Integer> squareAndNextEvenNumberTransformation =
                squareAndThenGetNextEvenNumberTransformation.apply(numbers);

        String space = "    ";
        StringBuilder result = new StringBuilder("");
        result.append(getStringFromList(idMapper)).append(space);
        result.append(getStringFromList(idTransfomarmation)).append(space);
        result.append(getStringFromList(mult2AndAdd1Mapper)).append(space);
        result.append(getStringFromList(mult2AndAdd1Tranformation)).append(space);
        result.append(getStringFromList(squareAndNextEvenMapper)).append(space);
        result.append(getStringFromList(squareAndNextEvenNumberTransformation)).append(space);

        System.out.println(result.toString().trim());
    }

    private static String getStringFromList(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder("");
        for (int n : numbers) {
            builder.append(n).append(" ");
        }
        return builder.toString().trim();
    }
}
