package functional.java_8_lambda;

import java.util.Comparator;

public class ComparatorLambda {
    public static void main(String[] args) {
        // prior to java 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println("Result of the comparator is :"+comparator.compare(3,2));
        //Comparator<Integer> comparatorLambda = (a,b)-> a.compareTo(b);
        Comparator<Integer> comparatorLambda = Integer::compareTo;
        System.out.println("Result of the comparator is :"+comparatorLambda.compare(3,2));

    }
}
