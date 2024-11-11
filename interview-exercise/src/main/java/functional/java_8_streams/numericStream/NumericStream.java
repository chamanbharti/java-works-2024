package functional.java_8_streams.numericStream;

import functional.ds.linear.dynamic.stack.LinkedStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStream {
    public static int sumOfNNumbers(List<Integer> integerList){
        return integerList.stream()
                .reduce(0,(x,y)->x+y);
        // unboxing to convert the integer to int
    }
    public static int sumOfNNumbers(){
        return IntStream.rangeClosed(1,6)
                .sum();
    }
    public static void main(String[] args) {
        List<Integer>list = Arrays.asList(1,2,3,4,5,6);
        System.out.println("Sum of N Numbers:"+sumOfNNumbers(list));
        System.out.println("Sum of N Numbers using IntStream:"+sumOfNNumbers());

    }
}
