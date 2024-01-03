import java.util.concurrent.Semaphore;

public class Program {

    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore semaphore = new Semaphore(numPhilosophers - 1);

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i+1, semaphore);
            new Thread(philosophers[i]).start();
        }
    }
}

