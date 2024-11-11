package functional.ds.collection.traversal.spliterator;

import java.util.*;
import java.util.stream.Stream;

// https://javaconceptoftheday.com/java-8-spliterator/
public class SpliteratorDemo {
    public static void main(String[] args) {

//tryAdvance() : Performs the given action on next element. It is used to traverse the elements one by one.
        //Spliterator from an array
        String[] languageArray = new String[] {"Java", "C", "C++", "Python", "Scala", "Kotlin"};
        Spliterator<String> spliteratorOfArray = Arrays.spliterator(languageArray);
        spliteratorOfArray.tryAdvance(System.out::println);

        //Spliterator from a List
        List<String> languageList = Arrays.asList(languageArray);
        Spliterator<String> spliteratorOfList = languageList.spliterator();
        spliteratorOfList.tryAdvance(System.out::println);

        //Spliterator from a Set
        Set<String> languageSet = new HashSet<>(Arrays.asList(languageArray));
        Spliterator<String> spliteratorOfSet = languageSet.spliterator();
        spliteratorOfSet.tryAdvance(System.out::println);

        //Spliterator from a Map
        Map<String,String>map = new HashMap<>();
        map.put("A","a");
        map.put("B","b");
        Spliterator<String>spliteratorOfMap = map.values().spliterator();
        spliteratorOfMap.tryAdvance(System.out::println);

        //Spliterator from a Stream
        Stream<String> languageStream = Stream.of("Java", "C", "C++", "Python", "Scala", "Kotlin");
        Spliterator<String> spliteratorOfStream = languageStream.spliterator();
        spliteratorOfStream.tryAdvance(System.out::println);
        spliteratorOfStream.tryAdvance(System.out::println);

        System.out.println("forEachRemaining() :");
// Performs the given action on each of the remaining elements.
// It is used to traverse the elements in bulk.
        List<String> languageList2 = Arrays.asList(languageArray);
        Spliterator<String>spliteratorOfList2 = languageList2.spliterator();
        spliteratorOfList2.forEachRemaining(System.out::println);

        System.out.println("trySplit() :");
// This method splits current Spliterator into another Spliterator. It is helpful in parallel programming.
        List<String> languageList3 = Arrays.asList("Java", "C", "C++", "Python", "Scala", "Kotlin");
        Spliterator<String> languageSpliterator = languageList3.spliterator();
        Spliterator<String> anotherLanguageSpliterator = languageSpliterator.trySplit();

        System.out.println("From 1st Spliterator");
        System.out.println("------------------");
        languageSpliterator.forEachRemaining(System.out::println);

        System.out.println("------------------");
        System.out.println("From 2nd Spliterator");
        System.out.println("------------------");
        anotherLanguageSpliterator.forEachRemaining(System.out::println);

        System.out.println("estimateSize() :");
        // It returns the estimate of number of elements yet to be traversed by the Spliterator.
        languageList = Arrays.asList("Java", "C", "C++", "Python", "Scala", "Kotlin");
        languageSpliterator = languageList.spliterator();
        System.out.println(languageSpliterator.estimateSize());       //Output : 6
        languageSpliterator.tryAdvance(System.out::println);
        System.out.println(languageSpliterator.estimateSize());       //Output : 5

        System.out.println("getExactSizeIfKnown() : ");
        //It returns exact size if known, otherwise returns -1.
        languageList = Arrays.asList("Java", "C", "C++", "Python", "Scala", "Kotlin");
        languageSpliterator = languageList.spliterator();
        System.out.println(languageSpliterator.getExactSizeIfKnown());       //Output : 6
        languageSpliterator.tryAdvance(System.out::println);
        System.out.println(languageSpliterator.getExactSizeIfKnown());       //Output : 5



    }
}
