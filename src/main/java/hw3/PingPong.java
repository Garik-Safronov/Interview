package hw3;

public class PingPong {

    private static Object monitor = new Object();
    private static volatile String currentWord = "Ping";

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                synchronized (monitor) {
                    for (int i = 0; i < 10; i++) {
                        while (currentWord != "Ping") {
                            monitor.wait();
                        }
                        System.out.println("Ping");
                        Thread.sleep(500);

                        currentWord = "Pong";
                        monitor.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (monitor) {
                    for (int i = 0; i < 10; i++) {
                        while (currentWord != "Pong") {
                            monitor.wait();
                        }
                        System.out.println("Pong");
                        Thread.sleep(500);

                        currentWord = "Ping";
                        monitor.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
