public class VarargsDemo {

   public static void main(String args[]) {
      // Вызов метода с переменной args  
      printMax(27, 11, 11, 5, 77.1);
      printMax(new double[]{10, 11, 12, 77, 71});
   }

   public static void printMax(double... numbers) {
      if (numbers.length == 0) {
         System.out.println("Ни один аргумент не передается");
         return;
      }

      double result = numbers[0];

      for (int i = 1; i <  numbers.length; i++)
      if (numbers[i] >  result)
      result = numbers[i];
      System.out.println("Максимальное значение " + result);
   }
}
