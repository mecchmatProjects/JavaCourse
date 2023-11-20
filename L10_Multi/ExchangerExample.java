import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // Потік 1
        new Thread(() -> {
            try {
                String dataFromThread1 = "Data from Thread 1";
                System.out.println("Thread 1 sends: " + dataFromThread1);

                // Виклик методу exchange() для обміну даними
                String receivedData = exchanger.exchange(dataFromThread1);

                System.out.println("Thread 1 receives: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Потік 2
        new Thread(() -> {
            try {
                String dataFromThread2 = "Data from Thread 2";
                System.out.println("Thread 2 sends: " + dataFromThread2);

                // Виклик методу exchange() для обміну даними
                String receivedData = exchanger.exchange(dataFromThread2);

                System.out.println("Thread 2 receives: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
