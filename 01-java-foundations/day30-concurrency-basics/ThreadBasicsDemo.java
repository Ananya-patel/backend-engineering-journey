

public class ThreadBasicsDemo {

    public static void main(String[] args) {

        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(
                    Thread.currentThread().getName() + " - " + i
                );
            }
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");

        t1.start();
        t2.start();

        System.out.println("Main thread finished");
    }
}


