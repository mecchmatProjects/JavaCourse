import java.util.*;
import java.util.stream.*;


class Lambda4 {
    @FunctionalInterface
	interface Convertor<F,T>{
	T convert(F from);
       }


    Convertor<String, Integer> convertor = (from)->Integer.valueOf(from);

    static int outerStaticNum;
    int outerNum;
    void testScopes() {
       Convertor<String, Integer> stringConverter1 = (from) -> {
            outerNum = 23;
           return Integer.valueOf(from);
        };
       Convertor<String, Integer> stringConverter2 = (from) -> {
            outerStaticNum = 72;
		return Integer.valueOf(from);
        };
    }
  

   public static void main(String[] args){
    Lambda4 x = new Lambda4();
    x.testScopes();
   }
}
