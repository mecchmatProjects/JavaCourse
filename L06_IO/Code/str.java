
class Str{

    public static void main(String[] args){
      String s1= "Це рядок."; 
      String s2 = "Це довгий рядок, " + "записаний в двох рядках вихідного тексту"; 
      String s3 = ""; // Порожній рядок
      String s = null; // Це порожній вказівник на рядок

      s = new String();
      System.out.println(s1+s2+s3+":"+s);
      s = new String("String class");
      System.out.println(s1+s2+s3+s);
      char[] helloArray = { 'П', 'р', 'и', 'в', 'і','т', '.'};
      String helloString = new String(helloArray);  
      System.out.println(helloString);
      char[] с = {'С', 'и', 'м', 'в', 'о', 'л', 'ь', 'н', 'и', 'й'}; 
      String s4 = String.copyValueOf(с); 
      String s5 = String.copyValueOf(с, 3, 7);

      String s6 = new String(с); 
      String s7 = new String(с, 3, 7);
      System.out.println(s4+s5+s6+":"+s7);
     
      String attention = "Увага: "; 
      String s8 = attention + "невідомий символ"; 
      attention += s8; 

      System.out.println("Рядок" + s8);

      String str1 = "Рядок номер 1";
      String str2 = new String("Рядок номер 2");
      String str0 =str1.concat(str2);
      System.out.println("Рядок: " + str1 + ", " + str0);
      String str3 = "My name is ".concat("Vasya");
    
      System.out.println("Рядок" + str3);

      String s9, s10, s11;
      s9= "2" + 2 + 2; // 222
      s10= 2 + 2 + "2"; // 42
      s11= "2" + (2 +2); // 24
      System.out.println("Рядок" + s9 + ", " + s10 + ", " + s11 + ", " );


    }
}

