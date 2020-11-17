class Threads4 implements Runnable{
   private String msg;
   private Thread go;
   Threads4(String s){
       msg = s;
       go = new Thread(this);
       go.start();
   }
   public void run(){
      Thread th = Thread.currentThread();
      while(go == th){
        try{
           Thread.sleep(100);
        }catch(InterruptedException ie){}
      System.out.print(msg + " ");
    }
    System.out.println("End of thread.");
  }

  public void stop(){ go = null; }

  public static void main(String[] args){
    Threads4 th1 = new Threads4("See");
    Threads4 th2 = new Threads4("Saw");
    try{
      Thread.sleep(1000);
    }catch(InterruptedException ie){}
    th1.stop(); th2.stop();
    System.out.println();
   }
}
