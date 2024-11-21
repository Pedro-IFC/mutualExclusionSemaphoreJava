package semaforo;

import java.util.concurrent.Semaphore;

public class Shared implements Runnable {
    private Semaphore semaforo;
    private String name;
    public Shared(Semaphore semaforo, String name) {
        this.semaforo = semaforo;
        this.name = name;
    }
    public void run() {
        try {
            System.out.println(this.name + " tentando acessar o recurso.");
            semaforo.acquire();
            System.out.println(this.name + " acessou o recurso.");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(this.name + " liberou o recurso.");
            semaforo.release();
        }
    }
	public Semaphore getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
