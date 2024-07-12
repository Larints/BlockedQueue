import static java.lang.Thread.sleep;

public class BlockedQueue {

    private int size = 0;

    public synchronized void getPoint() throws InterruptedException {
        while (size < 1) {
            wait();
        }
        size--;
        System.out.println("В очереди освободилось одно место");
        System.out.printf("Мест в очереди %d%n", size);
        sleep(1000);
        notify();
    }

    public synchronized void putPoint() throws InterruptedException {
        while (size >= 10) {
            wait();
        }
        size++;
        System.out.println("В очереди появилось одно место");
        System.out.printf("Мест в очереди %d%n", size);
        sleep(1000);
        notify();
    }

}
