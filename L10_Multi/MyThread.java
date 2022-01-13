public class MyThread extends Thread {
	private Synchro s;
	public MyThread(String str, Synchro s) {
		super(str);
		this.s = s;
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			s.writing(getName(), i);
		}
	}
}
