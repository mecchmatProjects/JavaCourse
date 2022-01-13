
class Tuple2{
   int x;
   int y;

   Tuple2(int x, int y){
      this.x = x;
      this.y = y;
   }   

   public void swap(){
      int tmp = x;
      x = y;
      y = tmp;
   }

   int getX(){
      return x;
   }

   int getY(){
      return y;
   }

}



public class Swap {

   int a,b;

   public static void main(String[] args) {
      int a = 30;
      int b = 45;
      System.out.println("Перед тем как передать, значения аргументов a = " + a + " и b = " + b);

      // Вызов метода передачи
      swapFunction(a, b);
      System.out.println("\nСейчас, до и после передачи значения аргументов ");
      System.out.println("остались неизменными, a = " + a + " и b = " + b);

      
      Tuple2 t = realSwap(a,b);
      a = t.getX();
      b = t.getY(); 
      
      System.out.println("swap a = " + a + " и b = " + b);
   }

   public static void swapFunction(int a, int b) {
      System.out.println("До замены: a = " + a + " b = " + b);
      
      // Передача параметров
      int c = a;
      a = b;
      b = c;
      System.out.println("После замены: a = " + a + " b = " + b);
   }

   

   public static Tuple2 realSwap(int a, int b) {
      System.out.println("До замены: a = " + a + " b = " + b);

      Tuple2 tmp = new Tuple2(a,b);
      tmp.swap();
      return tmp;
   }

}

