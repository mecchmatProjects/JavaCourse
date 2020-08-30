import java.util.Scanner;

class StrInp{

   public static void main(String[] args){
    int intVar = 42;
    float floatVar = 69.96f;
    String stringVar;
    Scanner sc = new Scanner(System.in);
    //stringVar = sc.next();
    stringVar = sc.nextLine();
    System.out.println("Значення floatVar=" + floatVar + ", при значенні intVar=" + intVar + "та stringVar=" + stringVar);
    System.out.printf("Значення floatVar=%f, при значенні intVar=%d, та stringVar" +  "=%s\n", floatVar, intVar, stringVar);
    String fs;
    fs = String.format("Значення floatVar=%f, при значенні intVar=%d, та stringVar=%s", floatVar, intVar, stringVar);
    System.out.println(fs);
   } 

}
