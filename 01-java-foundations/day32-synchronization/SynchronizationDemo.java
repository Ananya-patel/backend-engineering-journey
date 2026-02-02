public class SynchronizationDemo {

    static int counter = 0;

    static void increment() {
        synchronized (SynchronizationDemo.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter: " + counter);
    }
}
