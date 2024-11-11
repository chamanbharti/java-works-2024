package functional.java_8_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamMinMax {
    public static int findMax(List<Integer> integerList){
        return integerList.stream()
                /*
                 6 -> y
                 7 -> y
                 8 -> y
                 9 -> y
                 x variable holds the max value for each element in the iteration
                 x=0,y=6
                 x=6,y=7
                 x=7,y=8
                 x=8,y=9
                 x=9,y=10
                 */
                .reduce(0,(x,y)-> x>y?x:y);
                //.reduce(0,Integer::max);
    }
    public static Optional<Integer> findMaxOptional(List<Integer> integerList){
        return integerList.stream()
                /*
                 6 -> y
                 7 -> y
                 8 -> y
                 9 -> y
                 x variable holds the max value for each element in the iteration
                 x=0,y=6
                 x=6,y=7
                 x=7,y=8
                 x=8,y=9
                 x=9,y=10
                 */
                .reduce((x,y)-> x>y?x:y);
    }
    public static Optional<Integer> findMin(List<Integer> integerList){
        return integerList.stream()
                /*
                 6 -> y
                 7 -> y
                 8 -> y
                 9 -> y
                 x variable holds the max value for each element in the iteration
                 x=0,y=6
                 x=6,y=7
                 x=7,y=8
                 x=8,y=9
                 x=9,y=10
                 */
                .reduce((x,y)-> x<y?x:y);
        //.reduce(0,Integer::min);
    }
    public static void main(String[] args) {
        List<Integer> integerList = List.of(6,7,8,9,10);
        System.out.println(findMax(integerList));
       // integerList = new ArrayList<>();
        Optional<Integer>maxValue = findMaxOptional(integerList);
        if (maxValue.isPresent()){
            System.out.println("Max value:"+maxValue.get());
        }else {
            System.out.println("No value found may be list is empty:");
        }

        Optional<Integer>minValue = findMin(integerList);
        if (minValue.isPresent()){
            System.out.println("minValue:"+minValue.get());
        }else {
            System.out.println("No value found may be list is empty:");
        }

    }
}
