package functional.java.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindSecondHighestNo {
	public static void main(String[] args) {
//		List<Integer>list = Arrays.asList(3, 9, 1, 4, 8, 6);
		List<Integer>list = List.of(3, 9, 1, 4, 8, 6);
		System.out.println("list:"+list.stream().sorted((a,b) -> b-a).collect(Collectors.toList()));
		Optional<Integer>secondHighest = list.stream().sorted((a,b) -> b-a).skip(1).findFirst();
//		Optional<Integer>secondHighest = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("Second highest number: " + secondHighest.orElse(null));
	}

}
