import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {


    private final int id;
    private final Semaphore semaphore;

    public Philosopher(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();
            try {
                semaphore.acquire();
                haveLunch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public void think() {
        System.out.println("Философ " + id + " размышляет");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void haveLunch() {
        System.out.println("Философ " + id + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
