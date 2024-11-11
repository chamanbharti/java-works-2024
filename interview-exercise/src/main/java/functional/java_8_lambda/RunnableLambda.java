package functional.java_8_lambda;

public class RunnableLambda {
    public static void main(String[] args) {
        //Before java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };
        new Thread(runnable).start();

        // After java 8;
        Runnable runnableLambda = () -> {
            System.out.println("Inside Runnable 2");
        };
        new Thread(runnableLambda).start();

        Runnable runnableLambda1 = () -> System.out.println("Inside Runnable 3");
        new Thread(runnableLambda1).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 3.1");
            }
        }).start();

        new Thread(() -> System.out.println("Inside Runnable 4")).start();
    }
}
