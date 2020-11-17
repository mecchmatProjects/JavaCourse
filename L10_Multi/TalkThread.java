class TalkThreadC extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Talking");
			try {
				Thread.sleep(7); // остановка на 7 миллисекунд
			} catch (InterruptedException e) {
				System.err.print(e);
			}
		}
	}
}

public class TalkThread{

    public static void main(String[] args){

        TalkThreadC t = new TalkThreadC();
       // t.run();
         t.start();

    }

}
