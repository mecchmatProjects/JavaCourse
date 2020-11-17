class ThreadOne extends Thread{
   private String msg;
   ThreadOne(String s, String name){
   super(name); msg = s;
   }
   public void run() {
     for(int i = 0; i < 20; i++){
         // try{
         // Thread.sleep(100);
         // }catch(InterruptedException ie){}
     System.out.print(msg + " ");
   }
    System.out.println("End of " + getName());
  }
} 

class Thread1{
   public static void main(String[] args){
        new ThreadOne("See", "Thread 1").start();
        new ThreadOne("Saw", "Thread 2").start();
       System.out.println();
    }
}



