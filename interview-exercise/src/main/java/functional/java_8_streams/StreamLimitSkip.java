package functional.java_8_streams;

import java.util.List;
import java.util.Optional;

public class StreamLimitSkip {
    public static Optional<Integer> limit(List<Integer> integerList){
        return integerList.stream()
                /*
                6
                7
                8
                9
                10
                */
                .limit(3)//considering only 6,7,8
                .reduce( (x,y) -> x+y);
    }
    public static Optional<Integer> skip(List<Integer> integerList){
        return integerList.stream()
                /*
                 6
                 7
                 8
                 9
                 10
                 */
                .skip(3)//passing only 9,10
                .reduce( (x,y) -> x+y);
    }
    public static void main(String[] args) {
        List<Integer>integerList = List.of(6,7,8,9,10);
        Optional<Integer>limitResult = limit(integerList);
        if(limitResult.isPresent()){
            System.out.println("limit result is:"+limitResult.get());
        }else {
            System.out.println("no input is passed");
        }
        Optional<Integer>skipResult = skip(integerList);
        if(skipResult.isPresent()){
            System.out.println("skip result is:"+skipResult.get());
        }else {
            System.out.println("no input is passed");
        }

    }
}
