package functional.java.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurenceOfEachCharacter {
	
	public static void main(String[] args) {
		
		String str = "I love Java";
		Map<String,List<String>> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(s->s));
//		Map<String,List<String>> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity()));
		System.out.println(map);
		// output:{ =[ ,  ], a=[a, a], e=[e], v=[v, v], I=[I], J=[J], l=[l], o=[o]}
		// find each char occurrence
		Map<String,Long> map1 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map1);
		// output:{ =2, a=2, e=1, v=2, I=1, J=1, l=1, o=1}
		
		// find all duplicate element from a given string
		List<String> duplicateMap = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(x->x.getValue()>1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(duplicateMap);
		// output:[ , a, v]
		
		// find all unique element from a given string
		List<String> unique = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(x->x.getValue() == 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(unique);
		// output:[ , a, v]
		
		// find first non-repeat element from a string
		String firstNonRepeatElement = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.entrySet().stream()
				.filter(x->x.getValue() == 1)
				.findFirst().get().getKey();
		System.out.println(firstNonRepeatElement);
		
		
		
	}

}
