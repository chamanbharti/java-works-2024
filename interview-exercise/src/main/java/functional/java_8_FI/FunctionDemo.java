package functional.java_8_FI;

import java.util.function.Function;

public class FunctionDemo implements Function<Integer,Double> {

    /*
    @Override
    public String apply(String s) {
        return "welcome "+s+" in functional programing";
    }
    */

    @Override
    public Double apply(Integer i) {
        return i / 3.0;
    }
    public static void main(String[] args) {
        FunctionDemo functionDemo = new FunctionDemo();
        System.out.println(functionDemo.apply(10));

        Function<Integer,Double> list = a -> a/3.0;
        System.out.println(list.apply(10));
    }
}
