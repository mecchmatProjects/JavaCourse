import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class Curry{


	//public static IntUnaryOperator 

	public static IntBinaryOperator sumF(IntUnaryOperator f) {
    		return (a, b) -> f.applyAsInt(a) + f.applyAsInt(b);
	} 

public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator = (x, fx) -> 
			(a, b) -> { Integer s=a; for(int i=a+1;i<=b;i++) s=fx.applyAsInt(i,s); 
		return fx.applyAsInt(x,s);};

/**
 * The operator calculates the sum in the given range (inclusively)
 */
public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0,(a,b)->a+b); // write your code here

/**
 * The operator calculates the product in the given range (inclusively)
 */
public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1,(a,b)->a*b);// write your code here



	public static void main(String[] args){
		// build a new sumOfSquares operator
		IntBinaryOperator sumOfSquares = sumF(x -> x * x);
		// the sum is equal to 125
		long sum = sumOfSquares.applyAsInt(5, 10);

		System.out.println("s="+sum);
		// sum of two identities: 0 + 10 = 10
		long sumOfIdentities = sumF(x -> x).applyAsInt(0, 10);
		System.out.println("s="+sumOfIdentities);
		// sum with coefficients: 10 * 2 + 11 * 2 = 42
		long sumWithCoefficient = sumF(x -> x * 2).applyAsInt(10, 11);
		System.out.println("s="+sumWithCoefficient);
		// sum of two cubes: 3 * 3 * 3 + 8 * 8 * 8 = 539
		long sumOfCubes = sumF(x -> x * x * x).applyAsInt(3, 8);

		System.out.println("s="+sumOfCubes);
		
		IntBinaryOperator notCurriedFun = (x, y) -> x + y; // not a curried function

		IntFunction<IntUnaryOperator> curriedFun = x -> y -> x + y; // a curried function
		
		// curried function
		IntFunction<IntFunction<IntFunction<Integer>>> fff = x -> y -> z -> x * y + z;

		// fff returns a curried function y -> z -> 2 * y + z
		IntFunction<IntFunction<Integer>> ff = fff.apply(2);

		// ff returns a curried function z -> 2 * 3 + z
		IntFunction<Integer> f = ff.apply(3);

		// f returns 7
		int result = f.apply(1);
		System.out.println("R="+result);
		
		// the another result is equal to 153
		int anotherResult = fff.apply(10).apply(15).apply(3);
		System.out.println("R="+anotherResult);
		
		Function<IntUnaryOperator, IntBinaryOperator> sumF2 = (f1) -> (a, b) -> f1.applyAsInt(a) + f1.applyAsInt(b);
		// build a new sumOfSquares operator in terms of sumF
		IntBinaryOperator sumOfSquares2 = sumF2.apply(x -> x * x);
		// the sum is equal to 125 again
		long res_sum = sumOfSquares2.applyAsInt(5, 10);
		System.out.println("R="+res_sum);


	        Function<String, Consumer<String>> say = what -> whom -> System.out.println(what + ", " + whom);

		List<String> friends = Arrays.asList("John", "Neal", "Natasha");
		Consumer<String> sayHi = say.apply("Hi");
			// too many lines of a code...
		friends.forEach(sayHi);


		Function<IntBinaryOperator, IntBinaryOperator> sumF3 = (f2) -> (a, b) -> {
			Integer s=a; for(int i=a+1;i<=b;i++) s=f2.applyAsInt(i,s); return s;};

		IntBinaryOperator sumOfSquares3 = sumF3.apply((x,y) -> x + y);

		// the sum is equal to 125 again
		long res_sum3 = sumOfSquares3.applyAsInt(5, 10);
		System.out.println("R="+res_sum3);

		//Function<Integer,Integer,Integer> f6 = (x1,y1) -> {return x1 + y1;};
		//Function<Integer,Integer,Integer> f5 = (x,y) ->  x + y;


		//Function<Integer,Function<IntBinaryOperator,IntBinaryOperator>> sumF4 = (x) -> f3->f4 ->{return (z,t)-> 1;};
		

		/*
		IntBinaryOperator sumOfSquares4 = sumF4.apply((x,y) -> x + y);

		// the sum is equal to 125 again
		long res_sum4 = sumOfSquares4.applyAsInt(5, 10);
		System.out.println("R="+res_sum4);*/

		IntBinaryOperator summ = (x, y) -> x + y;
		IntBinaryOperator resultWithSumOperator = reduceIntOperator.apply(5, summ);
		int ss2 = resultWithSumOperator.applyAsInt(1, 4);   // 15 = 5 + (1 + 2 + 3 + 4)
		System.out.println("Z="+ss2);
                
                 //Passed IntBinaryOperator is production operator.
		IntBinaryOperator multiply = (x, y) -> x * y;
		IntBinaryOperator resultWitMultiplyOperator = reduceIntOperator.apply(5, multiply);
		ss2 = resultWitMultiplyOperator.applyAsInt(1, 4);   // 120 = 5 * (1 * 2 * 3 * 4)
		System.out.println("Z="+ss2);

		
		//sumOperator and productOperator produces int result:
		int ss3 = sumOperator.applyAsInt(1, 4);     // 10 = 1 + 2 + 3 + 4
		int ss4 = productOperator.applyAsInt(1, 4); // 24 = 1 * 2 * 3 * 4

		System.out.println("Zz="+ss3+"z="+ss4);

		//Example 2. Left boundary = 5, right boundary = 6.
		//Passed IntBinaryOperator is sum operator.
		IntBinaryOperator summm = (x, y) -> x + y;
		IntBinaryOperator resultWithSumOperator2 = reduceIntOperator.apply(2, summm);
		ss2 = resultWithSumOperator2.applyAsInt(5, 6);   // 13 = 2 + (5 + 6)
		System.out.println("Z="+ss2);

		//Passed IntBinaryOperator is production operator.

		IntBinaryOperator multiply1 = (x, y) -> x * y;
		IntBinaryOperator resultWitMultiplyOperator1 = reduceIntOperator.apply(2, multiply1);
		ss3 = resultWitMultiplyOperator1.applyAsInt(5, 6);   // 60 = 2 * (5 * 6)
		ss4 = resultWithSumOperator2.applyAsInt(5, 6);   // 13 = 2 + (5 + 6)
		System.out.println("Zz="+ss3+"z="+ss4);

		//sumOperator and productOperator produces int result:

		ss3 = sumOperator.applyAsInt(5, 6);     // 11 = 5 + 6
		ss4 = productOperator.applyAsInt(5, 6); // 30 = 5 * 6
		System.out.println("Zz="+ss3+"z="+ss4);

System.out.println("Sum: " + sumOperator.applyAsInt(1, 4));
System.out.println("Sum negative: " + sumOperator.applyAsInt(-3, 0));
System.out.println("Sum zero: " + sumOperator.applyAsInt(0, 4));
System.out.println("Sum same: " + sumOperator.applyAsInt(4, 4));
System.out.println("Sum zeros: " + sumOperator.applyAsInt(0, 0));

System.out.println("Product: " + productOperator.applyAsInt(1, 4));
System.out.println("Product negative: " + productOperator.applyAsInt(-3, -1));
System.out.println("Product zero: " + productOperator.applyAsInt(0, 4));
System.out.println("Product same: " + productOperator.applyAsInt(4, 4));
System.out.println("Product zeros: " + productOperator.applyAsInt(0, 0));

     }

}

