package features.java8.collectors.partitioningBy.partitioningBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByOverloaded {
	
	public static void main(String[] args) {

		System.out.println("PartitioningBy Examples");

		System.out.println("1. partitioningBy(Predicate<? super T> predicate)");
		Map<Boolean,List<String>> map1 = Stream.of("Apple","Apple", "Banana", "Cherry", "Date")
						.collect(Collectors.partitioningBy(
								 p -> p.startsWith("A")
								)
						);

		System.out.println("map1:"+map1);
		System.out.println("2. partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)");
		Map<Boolean, Set<String>> map2 = Stream.of("Apple", "Apple","Banana", "Cherry", "Date")
				.collect(Collectors.partitioningBy(
							p -> p.startsWith("A"),
							Collectors.toSet()
							)
				        );
		System.out.println("map2:"+map2);
		System.out.println("3. partitioningBy(Predicate<? super T> predicate, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)");

		Map<Boolean, Set<String>> map = Stream.of("Apple", "Banana", "Cherry", "Date")
				.collect(Collectors.partitioningBy(s -> s.startsWith("A"), Collectors.toSet()));
		System.out.println(map);
		System.out.println("PartitioningBy Examples");

		
		// Partitioning a List of Integers
		
		// Create a list of integers
	    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	    System.out.println("1. Basic Partitioning by Predicate");
	    // Partition the list into even and odd numbers
	    Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
	    		.collect(
	    				Collectors.partitioningBy(i -> i % 2 == 0)
	    				);
	    
	    // Output the result
	    System.out.print("Even Numbers:"+evenOddMap.get(true));
	    System.out.print("\nOdd Numbers:"+evenOddMap.get(false));
	    
	    // Partitioning Objects
	    // Create a list of Person objects
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 35),
                new Person("David", 15)
        );

        // Partition the list into adults (age >= 18) and minors
        Map<Boolean,List<Person>> partitionedMap = people.stream()
        		.collect(
        				Collectors.partitioningBy(
        						 p -> p.getAge() >= 18 // Predicate to partition
        						)
        				);
        
        System.out.print("\nadults:"+partitionedMap.get(true));
	    System.out.print("\nminors:"+partitionedMap.get(false));
	    
	    System.out.println("2. Partitioning with a Downstream Collector");
	 // Partition the list into even and odd numbers, counting each group
	    Map<Boolean,Long>endOddCount = numbers.stream()
	    		.collect(
	    				Collectors.partitioningBy(
	    						n -> n % 2 == 0, // Predicate to partition
	    						Collectors.counting() // Downstream collector
	    						)
	    				);
	    // Output the result
	    System.out.print("\nEven Numbers count:"+endOddCount.get(true));
	    System.out.print("\nOdd Numbers count:"+endOddCount.get(false));
	    
	    
	 // Partition the list into adults (age >= 18) and minors, counting each group
	    Map<Boolean,Long>partitionedCount = people.stream()
	    		.collect(
	    				Collectors.partitioningBy(
	    						 p -> p.getAge() >= 18, // Predicate to partition
	    						 Collectors.counting() // Downstream collector to count
	    						)	 
	    				);
	 // Output the result
        System.out.println("\nCount of Adults: " + partitionedCount.get(true));
        System.out.println("Count of Minors: " + partitionedCount.get(false));
        
        System.out.println("3. Partitioning with Downstream Collector");
     // Partition by age and count the number of persons in each group
        Map<Boolean, Long> partitionedByAgeCount = people.stream()
        		.collect(Collectors.groupingBy(
        										person -> person.getAge() >= 18,
        										Collectors.counting()
        				                     )
        				);
        // Output the result
        System.out.println("Count of Adults: " + partitionedByAgeCount.get(true));
        System.out.println("Count of Minors: " + partitionedByAgeCount.get(false));
        
     // Partition the list into adults (age >= 18) and minors, collecting names in each group
        Map<Boolean,List<String>>partitionedNames = people.stream()
        		.collect(
        				 Collectors.partitioningBy(
        						 p -> p.getAge() >= 18, // Predicate to partition
        				 Collectors.mapping(
        						 Person::getName, // Downstream collector to map names
        						 Collectors.toList() // Collect names into a list
        						 )
        				 )
        				);
        // Output the result
        System.out.println("Adults: " + partitionedNames.get(true));
        System.out.println("Minors: " + partitionedNames.get(false));
        
        
        System.out.println("4. Partitioning with Custom Downstream Collector");
     // Partition by age and collect names in a comma-separated string
        Map<Boolean,String> partitionedByAgeNames = people.stream()
        		.collect(
        					Collectors.partitioningBy(
        												person -> person.getAge() >= 18,
        												Collectors.mapping(Person::getName, Collectors.joining(",","{","}"))// Joining names
        											 )
        				);
        
        // Output the result
        System.out.println("Adults: " + partitionedByAgeNames.get(true));
        System.out.println("Minors: " + partitionedByAgeNames.get(false));
        
        
	}

}
