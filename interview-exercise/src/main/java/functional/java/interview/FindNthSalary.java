package functional.java.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNthSalary {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>();

		map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        Map.Entry<String, Integer> results = getNthHighestSalary(2, map1);
        System.out.println(results);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);
       Map<Integer,List<Map.Entry<String, Integer>>> result =  map2.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));

        System.out.println("GroupBy:"+result);
        // {1200=[ankit=1200, james=1200, bhavna=1200], 1300=[daniel=1300, tom=1300], 1000=[micael=1000, anil=1000]}

        // to improve output as
        // {1200=[ankit, james, bhavna], 1300=[daniel=1300, tom=1300], 1000=[micael, anil]}
        Map<Integer,List<String>> result1 = map2.entrySet().stream().collect(
        		Collectors.groupingBy(Map.Entry::getValue, 
        		Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println("GroupBy:"+result1);
        System.out.println(getDynamicNthHighestSalary(2, map2));



        System.out.println();
        
	}
	public static Map.Entry<String, Integer> getNthHighestSalary1(int num, Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num - 1);
    }
	  public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map) {
	        return map.entrySet().stream()
	                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	                .collect(Collectors.toList())
	                .get(num - 1);
	    }

	
	public static Map.Entry<Integer,List<String>> getDynamicNthHighestSalary1(int num,Map<String, Integer> map){
		return map.entrySet().stream().collect(
				Collectors.groupingBy(
						Map.Entry::getValue,
						Collectors.mapping(Map.Entry::getKey,Collectors.toList())
						
				))
		.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
		.collect(Collectors.toList())
		.get(num - 1);
	}
	  public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
	        return map.entrySet()
	                .stream()
	                .collect(Collectors.groupingBy(Map.Entry::getValue,
	                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
	                ))
	                .entrySet()
	                .stream()
	                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
	                .collect(Collectors.toList())
	                .get(num - 1);
	    }
	
	}
	
