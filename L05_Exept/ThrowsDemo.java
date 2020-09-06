// This program contains an error and will not compile.
class ThrowsDemo {
  static void throwOne() throws IllegalAccessException {
    System.out.println("Inside throwOne.");
    throw new IllegalAccessException("demo");
  }
  public static void main(String args[]) {
    try{
      throwOne();
    } 
    catch(IllegalAccessException e){
             System.out.println("Caught "+e);
    } 
  }
}
/*Without throws: Error: unreported exception IllegalAccessException; must be caught or declared to be thrown
    throw new IllegalAccessException("demo");
*/



/*
Inside throwOne.
Caught java.lang.IllegalAccessException: demo
*/


