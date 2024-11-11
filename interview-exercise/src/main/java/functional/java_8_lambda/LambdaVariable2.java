package functional.java_8_lambda;

import java.util.function.Consumer;

public class LambdaVariable2 {
    public static void main(String[] args) {
        int value = 0;
        Consumer<Integer> c1 = (i1) ->{
            //value++;
            System.out.println("Value is :"+value);
        };
        //value = 5;
        c1.accept(10);
    }

}
