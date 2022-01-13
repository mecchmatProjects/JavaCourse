

class H1{
   int z;
   public static int x; 
}


/*
 class Hello
*/
class Hello{
    // main function
    public static void main(String[] args){
        
      
        System.out.println("Hello, World! Привітання!");// System.out - object, println - static method
        int x=1;// int is not class
        char c='Б';
        double z=0;
        String s="Hello"; // String - not a base class 
 
        System.out.println("Виведення S=" + s +", " + z +"," + c + ", " + x);     

        H1 c1;
        c1 = new H1();
        c1.x = 2;
         System.out.println("c1.x="+c1.x + ",z=" + c1.z);

        H1 c2 = new H1();
        c2.x = 3;//c1.x =c2.x=3

        System.out.println("c2.x="+c2.x + "," + c1.x);

        for(int i=0;i<args.length;i++){
           System.out.print("arg[ "+ i+"]="+args[i]);
        }
    }
}
