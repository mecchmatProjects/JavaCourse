class Char{

   public static void main(String[] args){
     String s = "Write once, run anywhere."; 
     int len = s.length(); 
     char ch = s.charAt(3); 
     char[] mas = s.toCharArray();
     char z = mas[3]; 
 
     System.out.printf("s=%c s=%c \n",ch, z); 
     
     char[] mas1 = new char[50]; 
     mas1[0]='A';
     //getChars(int begin, int end, char[] dst, int ind)
     s.getChars(2, 5, mas1, 0);
     System.out.println(new String(mas1));

     try{
     s.getChars(5, 2, mas1, 1);
     s.getChars(2, 32, mas1, 1);
     s.getChars(2, 5, mas1, -1);
     }
     catch(StringIndexOutOfBoundsException e){
     System.out.println("Don't do this way!!");
    }
     
     String sub1 = s.substring(6, 10);
     String sub2 = s.substring(16);
     int num = "молоко".indexOf('о',"молоко".indexOf('о') + 1);
     System.out.printf("n=%d",num);
     int num2 = "молоко".lastIndexOf('о',"молоко".lastIndexOf('о')+1);
     System.out.printf("n=%d",num2);
     System.out.println("Рука в руку сует хлеб".replace ('у', 'е'));

   }
}
