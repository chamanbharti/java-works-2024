package functional.java_8_FI;

import java.util.function.BiConsumer;

public class BiConsumerDemo implements BiConsumer<Integer,Integer> {

    @Override
    public void accept(Integer input1,Integer input2) {
        //System.out.println("Accept : "+input1+input2);//Accept : 1010
        System.out.println(input1+input2);//Accept : 20
    }

    public static void main(String[] args) {
        Integer input = 10;

        System.out.println("first approach");
        BiConsumerDemo consumerDemo = new BiConsumerDemo();
        consumerDemo.accept(input,input);
        //consumerDemo.accept(list);

        System.out.println("second approach");
        BiConsumer<Integer,Integer> biConsumer = (i,j) -> System.out.println(i+j);
        biConsumer.accept(10,10);
    }

}
