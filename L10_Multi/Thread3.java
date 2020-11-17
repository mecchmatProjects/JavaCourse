class Thread3 implements Runnable{

    private String msg;
    Thread3(String s){ msg = s; }

    public void run(){
       for(int i = 0; i < 20; i++){
          try{
           Thread.sleep(100);
          }catch(InterruptedException ie){}
       System.out.print(msg + " ");
     }
    System.out.println("End of " + msg);
    }
    public static void main (String[] args){
      new Thread(new Thread3("See"), "Thread 1").start ();
      new Thread(new Thread3("Saw"), "Thread 2").start ();
      System.out.println();
    }
}
