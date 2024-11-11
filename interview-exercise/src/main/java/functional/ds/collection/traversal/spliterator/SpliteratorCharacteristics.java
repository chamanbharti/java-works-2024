package functional.ds.collection.traversal.spliterator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.IntConsumer;
// https://www.logicbig.com/tutorials/core-java-tutorial/java-collections/iterator-spliterator.html
public class SpliteratorCharacteristics {
    public static void main(String[] args) {

        String[] languageArray = new String[] {"Java", "C", "C++", "Python", "Scala", "Kotlin"};
        Spliterator<String> spliteratorOfArray = Arrays.spliterator(languageArray);
        spliteratorOfArray.tryAdvance(System.out::println);

        //Spliterator from a List
        List<String> languageList = Arrays.asList(languageArray);

        System.out.println("characteristics");
        // Checks whether this Spliterator has specified characteristics or not.
        System.out.println("characteristics:"+spliteratorOfArray.characteristics());
        System.out.println("hasCharacteristics of 17488:"+spliteratorOfArray.hasCharacteristics(17488));

        System.out.println("getComparator() : ");
        // It returns Comparator of the source if it is sorted, otherwise throws IllegalStateException.
        // If the source is sorted in natural order, it returns null.
        //System.out.println(languageSpliterator.getComparator());

        System.out.println("characteristics() and hasCharacteristics()");
        Spliterator<String> spliteratorList = languageList.spliterator();
        System.out.println("Spliterator from a List");
        if(spliteratorList.hasCharacteristics(Spliterator.ORDERED)){
            System.out.println("ORDERED");//ORDERED
        }
        if(spliteratorList.hasCharacteristics(Spliterator.SIZED)){
            System.out.println("SIZED");//SIZED
        }
        if(spliteratorList.hasCharacteristics(Spliterator.SUBSIZED)){
            System.out.println("SUBSIZED");//SUBSIZED
        }

        System.out.println("Spliterator from a Set");
        Set<String> languageSet = new HashSet<>(Arrays.asList(languageArray));
        Spliterator<String> spliteratorOfSet = languageSet.spliterator();
        if(spliteratorOfSet.hasCharacteristics(Spliterator.DISTINCT)){
            System.out.println("DISTINCT");
        }
        System.out.println("Spliterator from a SortedSet");

        //SortedSet<Test> sortedSet = new TreeSet<>( (o1,o2) -> o1.str.compareTo(o2.str));
        SortedSet<Test> sortedSet = new TreeSet<>(Comparator.comparing(o -> o.str));
        sortedSet.add(new Test("two"));
        sortedSet.add(new Test("one"));
        Spliterator<Test>spliteratorOfSortedSet = sortedSet.spliterator();
        if(spliteratorOfSortedSet.hasCharacteristics(Spliterator.SORTED)){
            System.out.println("SORTED");
        }
        System.out.println("getComparator:"+spliteratorOfSortedSet.getComparator());

        System.out.println("Spliterator from a ConcurrentHashMap");
        Map<String,String> concurrentMap = new ConcurrentHashMap();
        concurrentMap.put("A","a");

        Spliterator<String> spliteratorOfConcurrentMap = concurrentMap.values().spliterator();
        if(spliteratorOfConcurrentMap.hasCharacteristics(Spliterator.CONCURRENT)){
            System.out.println("CONCURRENT");
        }
        if(spliteratorOfConcurrentMap.hasCharacteristics(Spliterator.NONNULL)){
            System.out.println("NONNULL");
        }

        List<String> languageListImmutable = Collections.unmodifiableList(Arrays.asList(languageArray));
        //languageListImmutable.add("A");
        Spliterator<String>spliteratorOfImmutableList = languageListImmutable.spliterator();
        if(spliteratorOfImmutableList.hasCharacteristics(Spliterator.IMMUTABLE)){
            System.out.println("IMMUTABLE");
        }

        System.out.println("Spliterator implementation for primitives");
        int[] ints = {3,4,6,7};
        Spliterator.OfInt s = Arrays.spliterator(ints);
        s.forEachRemaining((IntConsumer) System.out::println);

        System.out.println("Spliterators class");
        Spliterator<String> ss = Spliterators.spliterator(
                new String[]{"one", "two"}, 0);
        ss.forEachRemaining(System.out::println);

    }
    private static class Test {
        private final String str;

        private Test (String str) {
            this.str = str;
        }

        @Override
        public String toString () {
            return "Test{str='" + str + "'}";
        }
    }
}
