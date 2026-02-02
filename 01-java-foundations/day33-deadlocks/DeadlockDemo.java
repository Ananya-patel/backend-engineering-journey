public class DeadlockDemo {

    static final Object lockA = new Object();
    static final Object lockB = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: Holding lockA");
                sleep();
                synchronized (lockB) {
                    System.out.println("Thread 1: Holding lockB");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2: Holding lockB");
                sleep();
                synchronized (lockA) {
                    System.out.println("Thread 2: Holding lockA");
                }
            }
        });

        t1.start();
        t2.start();
    }

    static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
