import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors;



public class Gener{

    public static void main(String[] args){
 
  List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

  List<Integer> generated = numbers.stream()
        .flatMap(n -> Stream.generate(() -> n).limit(n))
        .collect(Collectors.toList());

  System.out.println(generated);


List<Integer> generated2 = numbers.stream()
        .flatMapToInt(n -> IntStream.rangeClosed(1, n))
        .boxed()
        .collect(Collectors.toList());

  System.out.println(generated2);

List<Integer> generated3 = numbers.stream()
        .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
        .boxed()
        .collect(Collectors.toList());

  System.out.println(generated3);

List<Integer> generated4 = numbers.stream()
        .flatMap(Stream::of)
        .collect(Collectors.toList());
  System.out.println(generated4);
}

}

