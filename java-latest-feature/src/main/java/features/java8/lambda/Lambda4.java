package features.java8.lambda;
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }
}

public class Lambda4 {
    public static void main(String[] args) {

        System.out.println("Without Lambda");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Parent Thread");
        }

        System.out.println("With Lambda");
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread");
            }
        };
        Thread thread1 = new Thread(r);
        thread1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Parent Thread");
        }

    }
}
