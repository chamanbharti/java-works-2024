package functional.java.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionListIntoTwoList {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Java", "Go", "Python", "C", "Ruby");

        Map<Boolean, List<String>> partitioned = strings.stream()

                                                        .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println(partitioned);

        System.out.println("Strings with length > 3: " + partitioned.get(true));

        System.out.println("Strings with length <= 3: " + partitioned.get(false));
        
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        
        Map<Boolean, List<Integer>> oddEvenNumbersMap = 
                listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Even Numbers"+oddEvenNumbersMap.get(true));
        System.out.println("Odd Numbers"+oddEvenNumbersMap.get(false));
	}

}
