package functional.java_8_collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-collectors-tomap
public class CollectorsToMap {

    // how to get the key and value for the map
    public Map<String,String> listToMap(List<Book> books){
        return books.stream().collect(Collectors.toMap(Book::getIsbn,Book::getName));
    }

    // Solving Key Conflicts
    public Map<Integer,Book> listToMapWithDuplicateKeyError(List<Book> books){
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity())
        );

    }

    // To resolve it, we need to use a different method with an additional parameter, the mergeFunction:
    public Map<Integer,Book> listToMapWithDuplicateKeyResolved(List<Book> books){
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity(), (existing, replacement) -> existing)
        );
    }

    // List to ConcurrentMap
    public Map<Integer, Book> listToConcurrentMap(List<Book> books) {
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new)
        );
    }

    public TreeMap<String, Book> listToSortedMap(List<Book> books) {
        return books.stream()
                .collect(
                        Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new)
                );
    }
}
