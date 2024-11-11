package features.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        String sentence = "Java Programming Language";

        System.out.println("Finding the nth Repeated Character");
        Map<Character, Long> repeatedMap = sentence.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("repeatedMap: " + repeatedMap);

        int n = 2; // Change this value for different nth
        System.out.println("The " + n + "th repeated character is: " + findNthRepeated(sentence, n));

        System.out.println("Finding the non Repeated Character");
        Map<Character, Long> nonRepeatedMap = sentence.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() == 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("nonRepeatedMap: " + nonRepeatedMap);
        System.out.println("The " + n + "th non-repeated character is: " + findNthNonRepeated(sentence, n));

        Character result = sentence.chars() // IntStream
                .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))) // convert to lowercase & then to Character object Stream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))// store in a LinkedHashMap with the count
                .entrySet().stream()// EntrySet stream
                .filter(entry -> entry.getValue() == 1L)// extracts characters with a count of 1
                .map(entry -> entry.getKey()) // get the keys of EntrySet
                .findFirst().get();// get the first entry from the keys
        System.out.println(result);

        LinkedHashMap<Character, Long> collect = sentence.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect);

        Map<Character, Long> collect1 = collect.entrySet().stream().filter(e -> e.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect1);

        Character c = collect.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(c);

        collect =  sentence.chars().mapToObj(i -> (char)i).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        collect.forEach( (x,y) -> System.out.println( "Key: " + x + " Val: " + y));

        Optional<Character> firstNonRepeat = collect.entrySet().stream().filter( (e) -> e.getValue() == 1).map(e -> e.getKey()).findFirst();
        if(firstNonRepeat.isPresent()) {
            System.out.println("First non repeating:" + firstNonRepeat.get());
        }
        Optional<Character> firstRepeat = collect.entrySet().stream().filter( (e) -> e.getValue() > 1).map(e -> e.getKey()).findFirst();
        System.out.println("First repeating:" + firstRepeat.orElse(null));

    }

    private static char findNthRepeated(String str,int n) {
        Map<Character, Long> frequencyMap  =  str.chars()
                .mapToObj(c -> (char) c)
                .collect(
                         Collectors.groupingBy(
                                               c -> c,
                                               Collectors.counting()
                                              )
                        );
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Keep only repeated characters
                .map(Map.Entry::getKey)
                .distinct()
                .skip(n - 1) // Skip to the nth repeated character
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not enough repeated characters"));

    }

    public static char findNthNonRepeated(String str, int n) {
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // Keep only non-repeated characters
                .map(Map.Entry::getKey)
                .skip(n - 1) // Skip to the nth non-repeated character
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not enough non-repeated characters"));
    }
}
