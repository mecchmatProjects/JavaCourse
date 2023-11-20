import java.util.concurrent.Semaphore;

public class ExampleSamaphore {
    private static final int MAX_AVAILABLE_PERMITS = 5;
    private static final Semaphore semaphore = new Semaphore(MAX_AVAILABLE_PERMITS);

    public static void main(String[] args) {
        // Multiple threads trying to access a limited resource
        for (int i = 0; i < 10; i++) {
            new Thread(() -> accessResource()).start();
        }
    }

    private static void accessResource() {
        try {
            semaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getId() + " is accessing the resource.");
            // Simulating some work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Thread " + Thread.currentThread().getId() + " released the resource.");
        }
    }
}
