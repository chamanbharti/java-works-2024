package functional.java_8_lambda;

import java.util.function.Consumer;

public class LambdaVariable1 {
    static int value=4;
    public static void main(String[] args) {
        /*
        int i = 0;
        Consumer<Integer> c1 = (i1) ->{
            System.out.println("Value is :"+i);
        };
        */
        /*
        int i = 4;
        Consumer<Integer> c1 = (i1) ->{
            System.out.println("Value is :"+i+1);
        };
        c1.accept(3);
         */

        Consumer<Integer> c1 = (i1) ->{
            value++;
            System.out.println("Value is :"+value+i1);
        };
        c1.accept(4);
    }

}
