package semaforo;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        Thread t1 = new Thread(new Shared(semaforo, "Thread-1"));
        Thread t2 = new Thread(new Shared(semaforo, "Thread-2"));
        Thread t3 = new Thread(new Shared(semaforo, "Thread-3"));
        t1.start();
        t2.start();
        t3.start();
    }
}
