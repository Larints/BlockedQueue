import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        BlockedQueue blockedQueue = new BlockedQueue();
        Thread putThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockedQueue.putPoint();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted");
                }
            }
        });
        Thread getThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockedQueue.getPoint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        putThread.start();
        getThread.start();
    }

}

