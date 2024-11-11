package functional.java_8_FI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo implements Consumer<List<Integer>> {


    /*
     @Override
    public void accept(Integer input) {
        System.out.println("Accept : "+input);
    }
    */
    public void accept(List<Integer> list) {
        for (Integer input:list) {
            System.out.println("Accept : " + input);
        }
    }
    public static void main(String[] args) {
        Integer input = 1010;
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        System.out.println("first approach");
        ConsumerDemo consumerDemo = new ConsumerDemo();
        //consumerDemo.accept(input);
        consumerDemo.accept(list);

        System.out.println("second approach");
        list.stream().forEach(t -> System.out.println("Accept : "+t));
    }

}
