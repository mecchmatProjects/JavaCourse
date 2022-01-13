import java.util.Optional;

public class OptionTest {

   public static void main(String args[]) {
      OptionTest Opt = new OptionTest();
      Integer value1 = null;
      Integer value2 = new Integer(10);
                
      //Optional.ofNullable - allows passed parameter to be null.
      Optional<Integer> a = Optional.ofNullable(value1); // 
      //Optional.of - throws NullPointerException if passed parameter is null
      Optional<Integer> b = Optional.of(value2);
      Optional<Integer> c = Optional.ofNullable(value2);
      System.out.println(Opt.sum(a,b,c));

      Optional<String> d = Optional.of("bam");

      d.isPresent();           // true
      d.get();                 // "bam"
      d.orElse("fallback");    // "bam"
      d.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
   }
        
   public Integer sum(Optional<Integer> a, Optional<Integer> b,Optional<Integer> c) {
      //Optional.isPresent - checks the value is present or not
                
      System.out.println("First parameter is present: " + a.isPresent());
      System.out.println("Third parameter is present: " + c.isPresent());
                
      //Optional.orElse - returns the value if present otherwise returns
      //the default value passed.
      Integer value1 = a.orElse(new Integer(0));
                
      //Optional.get - gets the value, value should be present
      Integer value2 = b.get();

      Integer value3 = c.orElse(new Integer(0));
      return value1 + value2 + value3;
   }
}
