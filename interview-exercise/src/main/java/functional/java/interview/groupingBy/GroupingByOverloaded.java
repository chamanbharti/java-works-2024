package functional.java.interview.groupingBy;
import functional.java.interview.partitioningBy.Person;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByOverloaded {

	public static void main(String[] args) {
		List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 30),
                new Person("David", 20),
                new Person("Eve", 25)
        );

		System.out.println("1. Basic Grouping by Classifier Function");
        // Group by age
		Map<Integer, List<Person>> groupedByAge = people.stream()
				.collect(
						 Collectors.groupingBy(Person::getAge)

						);
		// Output the result
		groupedByAge.forEach(
								(age,persons) -> 
								System.out.println("Age:"+age+", Persons:"+persons)
							);
		
		System.out.println("2. Grouping with a Downstream Collector");
		  // Group by age and collect names in a list
		Map<Integer, List<String>> groupedByAge2 = people.stream()
				.collect(Collectors.groupingBy(
												Person::getAge,
												Collectors.mapping(Person::getName, Collectors.toList())
											  )
						);

		// Output the result
		groupedByAge2
		
		.forEach( (age,names) -> System.out.println("Age:"+age+", Names:"+names));
		
		System.out.println("3. Grouping with a Classifier Function and Downstream Collector for Aggregation");
		// Group by age and count the number of persons in each group
		Map<Integer, Long> groupedByAgeCount = people.stream()
				.collect(Collectors.groupingBy(
												Person::getAge,
												Collectors.counting()// Downstream collector to count
											   )
						);
		 // Output the result
        groupedByAgeCount.forEach((age, count) -> 
            System.out.println("Age: " + age + ", Count: " + count)
        );
				
		System.out.println("4. Grouping by Classifier Function and Custom Downstream Collector");
		// Group by age and collect names in a comma-separated string
        Map<Integer, String> groupedByAgeNames = people.stream()
        		.collect(
        				Collectors.groupingBy(
        						Person::getAge,
        						Collectors.mapping(
        								Person::getName, 
        								Collectors.joining(",")
        								)
        						)
        				);
        
        groupedByAgeNames.forEach( (age,names) -> System.out.println("Age:"+age+",Name:"+names));
        ;
	}
}
