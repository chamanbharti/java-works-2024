package functional.java_8_FI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo implements Predicate<List<Integer>>{
   /*
    @Override
    public boolean test(Integer input) {
        if(input % 2 == 0)
            return true;
        else
            return false;
    }
    */
   @Override
   public boolean test(List<Integer> list) {
       for (Integer input:list){
           if (input % 2 == 0){
               System.out.println("Print Even : "+input);
           }
       }
       return false;
   }

    public static void main(String[] args) {
        Integer input = 1010;
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        System.out.println("first approach");
        PredicateDemo predicateDemo = new PredicateDemo();
       // System.out.println( predicateDemo.test(input));
        predicateDemo.test(list);

        System.out.println("second approach");
        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("Print Even : "+t));
    }


}
