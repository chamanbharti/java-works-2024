package functional.java.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicateFromList {
	public static void main(String[] args) {
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6);
		 Map<Integer,Long> occurence = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println("occurence:"+occurence);
		 System.out.println("Distinct Number:"+
				 numbers.stream().distinct().collect(Collectors.toList())
				 );
		 
		 List<String> strings = Arrays.asList("A", "B", "A", "A", "A", "A", "A", "B");
		 System.out.println("Distinct string:"+
				 strings.stream().distinct().collect(Collectors.toList())
				 );
		 
		 
	}

}
