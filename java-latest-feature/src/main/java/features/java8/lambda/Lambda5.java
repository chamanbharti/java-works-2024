package features.java8.lambda;

public class Lambda5 {
    public static void main(String[] args) {
        /*
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Child Thread");
                }
            }
        });
        */
        Thread thread1 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread");
            }
        });
        thread1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Parent Thread");
        }
    }
}
