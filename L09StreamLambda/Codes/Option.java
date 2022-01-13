import java.util.Optional;

public class OptionTest {

   public static void main(String args[]) {
      OptionTest Opt = new OptionTest();
      Integer value1 = null;
      Integer value2 = new Integer(10);
                
      //Optional.ofNullable - allows passed parameter to be null.
      Optional<Integer> a = Opt.ofNullable(value1);
                
      //Optional.of - throws NullPointerException if passed parameter is null
      Optional<Integer> b = Opt.of(value2);
      System.out.println(Option.sum(a,b));

      Optional<String> optional = Opt.of("bam");

      optional.isPresent();           // true
      optional.get();                 // "bam"
      optional.orElse("fallback");    // "bam"

      optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

   }
        
   public Integer sum(Optional<Integer> a, Optional<Integer> b) {
      //Optional.isPresent - checks the value is present or not
                
      System.out.println("First parameter is present: " + a.isPresent());
      System.out.println("Second parameter is present: " + b.isPresent());
                
      //Optional.orElse - returns the value if present otherwise returns
      //the default value passed.
      Integer value1 = a.orElse(new Integer(0));
                
      //Optional.get - gets the value, value should be present
      Integer value2 = b.get();
      return value1 + value2;
   }

   public Optional<Integer> optionalAdd(Optional<Integer> val1, Optional<Integer> val2) {
     return
           val1.flatMap( first ->
   	        val2.flatMap( second ->
   		       Optional.of(first + second)
    ));
}

public static <T, U, R> Optional<R> flatMap2(Optional<T> opt1,
                                             Optional<U> opt2,
                                             BiFunction<T, U, Optional<R>> mapper) {
    return
            opt1.flatMap(a ->
            opt2.flatMap(b ->
            mapper.apply(a, b)
    ));
}

public Optional<Integer> addOptionals(Optional<Integer> opt1, Optional<Integer> opt2) {
    return flatMap2(opt1, opt2, (param1, param2) -> Optional.of(param1 + param2));
}
}
