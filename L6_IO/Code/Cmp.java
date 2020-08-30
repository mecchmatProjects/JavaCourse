import java.util.Scanner;

class Cmp{

 public static void main(String[] args) {
   String s1 = "Якийсь рядок";
   String s2 = "Інший рядок"; 
   String s3 = "Інший рядок"; 
   System.out.println((s1==s2)?"Equal":"Not Equal"); // Not Equal
   if(s3==s2) {System.out.println("Equal"); // Equal
   }else{System.out.println("Not Equal");}
   
   System.out.println(s1.equals(s2)+", " + s3.equals(s2));//false,true
   System.out.println(s1.equalsIgnoreCase(s2)); // false
   //compareTo(string str)
   System.out.println(s1.compareTo(s2) + ", " + s3.compareTo(s2));// 41, 0
   System.out.println(s2.compareToIgnoreCase(s3)); // 0

   Scanner sc = new Scanner(System.in);
   String stringVar = sc.nextLine();

   if(stringVar.toLowerCase().startsWith("hello")){
    System.out.println("Hello");
   }
   if(stringVar.endsWith("!")){
    System.out.println("Greet");
   }
  if(stringVar.contains("!")){
    System.out.println("Greeting");
  }
  // regionMatches (int toffset, String other, int ooffset, int len)
  if("ELLO".regionMatches(0,stringVar.toUpperCase(),1,3)){
    System.out.println("was hello");
   }

  }
}
