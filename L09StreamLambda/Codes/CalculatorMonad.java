
import java.math.BigDecimal;
import java.util.function.*;

/**
 * @author Poshivalov N.A.
 * @since 12.07.2017.
 */
public class CalculatorMonad<T extends Number> {

    private T value;

    private CalculatorMonad(T value){
        this.value = value;
    }

    public static <V extends Number> CalculatorMonad<V> of(V value){
        return new Calculator<>(value);
    }

    public T get(){
        return value;
    }

    public<U extends Number>  CalculatorMonad<U> evaluation(Function<? super T, CalculatorMonad<U>> mapper){
        return mapper.apply(value);
    }

    public<U extends Number> CalculatorMonad<U> process(Function<? super T, ? extends U> mapper){
        return Calculator.of(mapper.apply(value));
    }

    public CalculatorMonad<T> glance(Consumer<? super T> consumer){
        consumer.accept(value);
        return this;
    }

}


class Main{
    public static void main(String[] args){
        double s = CalculatorMonad.of(BigDecimal.TEN)
                .evaluation(value -> Calculator.of(value.add(new BigDecimal(70))))
                .process(BigDecimal::doubleValue)
                .glance(System.out::println)
                .get();

        int m = CalculatorMonad.of(20.0)
                .process(v -> v / 90)
                .evaluation(v -> Calculator.of(57 + v.intValue()))
                .process(v -> v * 20)
                .glance(System.out::println)
                .get();

        System.out.println(s + m);
    }
}

