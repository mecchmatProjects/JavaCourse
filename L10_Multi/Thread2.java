class Thread2 extends Thread{
  private String msg;
  Thread2(String s, String name){
    super(name); msg = s;
  }

  public void run(){
     for(int i = 0; i < 20; i++){
        try{
         Thread.sleep(100);
        }catch(InterruptedException ie){}
       System.out.print(msg + " ");
     }
     System.out.println("End of " + getName());
  }

  public static void main(String[] args){
     new Thread2("See", "Thread 1").start();
     new Thread2("Saw", "Thread 2").start();
     System.out.println();
  }
}
