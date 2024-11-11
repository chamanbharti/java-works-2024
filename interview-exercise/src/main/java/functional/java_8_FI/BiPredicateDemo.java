package functional.java_8_FI;

import java.util.function.BiPredicate;

public class BiPredicateDemo implements BiPredicate<Integer,Integer> {

    @Override
    public boolean test(Integer t, Integer u) {
        if (t > u){
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {

        System.out.println("first approach");
        BiPredicateDemo predicateDemo = new BiPredicateDemo();
       // System.out.println( predicateDemo.test(input));
        System.out.println(predicateDemo.test(20,10));

        System.out.println("second approach");
       // BiPredicate<Integer,Integer> biPredicate = (i,j) -> (i>j)? true:false;
        BiPredicate<Integer,Integer> biPredicate = (i,j) -> {
            if (i > j){
                return true;
            }
            else
                return false;
        };
        System.out.println(predicateDemo.test(20,10));
    }



}
