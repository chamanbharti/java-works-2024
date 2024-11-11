package functional.java.interview.collectors.mapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import functional.java.interview.partitioningBy.Person;

public class MapAndMapping {
	
	public static void main(String[] args) {
		
		 List<Person> people = List.of(
	                new Person("Alice", 30),
	                new Person("Bob", 20),
	                new Person("Bob", 20),
	                new Person("Charlie", 25)
	        );

	        
		 System.out.println("stream().map()");
		List<String> listNamedMap = people.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println("List Of Names:"+listNamedMap);
		System.out.println(people.stream().map(Person::getAge).collect(Collectors.toList()));
		Set<String> setNamedMap = people.stream().map(Person::getName).collect(Collectors.toSet());
		System.out.println("List Of Names:"+setNamedMap);
		System.out.println(people.stream().map(Person::getAge).collect(Collectors.toSet()));
		
		 System.out.println("collector.mapping()");
		 System.out.println("1. Basic Collectors.mapping() Example");
		// Map the Person objects to their names and collect in a list
		List<String> listOfNames = people.stream().collect(Collectors.mapping(Person::getName, Collectors.toList()));
		// this line is equal to below ling
	  //List<String> listNamedMap = people.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println("listOfName:"+listOfNames);
		
		System.out.println("2. Collectors.mapping() with Grouping");
		// Group by age and collect names in a list for each age group
        Map<Integer, List<String>> namesByAge = people.stream()
        		.collect(
        				Collectors.groupingBy(
        						Person::getAge,// Classifier function to group by age
        				        Collectors.mapping(Person::getName, Collectors.toList())// Downstream collector
        				       )
        				);
        System.out.println("namesByAge:"+namesByAge);
        
        System.out.println("3. Collectors.mapping() with Counting");
     // Group by the first letter of names and count the number of people whose name starts with that letter
        Map<Character, Long> nameCountByInitial = people.stream()
        		.collect(Collectors.groupingBy(
        				person -> person.getName().charAt(0),// Classifier function to group by first letter
        				Collectors.mapping(Person::getName, Collectors.counting())// Downstream collector to count
        				)
        				);
        System.out.println("nameCountByInitial:"+nameCountByInitial);
        
        System.out.println("4. Collectors.mapping() with Joining");
     // Group by age and collect names as a comma-separated string for each age group
        Map<Integer, String> namesByAge2 = people.stream()
        		.collect(Collectors.groupingBy(
        				Person::getAge,// Classifier function to group by age
        				Collectors.mapping(Person::getName, Collectors.joining(","))// Downstream collector
        				));
        System.out.println("namesByAge2:"+namesByAge2);
		
		
		
	}

}
