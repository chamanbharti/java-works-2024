package functional.java_10_features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CopyOfFeatureForImmutability {
//https://www.logicbig.com/tutorials/core-java-tutorial.html
    public static void main(String[] args) {
        System.out.println("Immutability for List");
        List<String> names = new ArrayList<>();
        names.add("Chaman");
        names.add("Bhart");
        doNotChange_List(names);
        System.out.println(names);

        List<String> copyOfNames = List.copyOf(names);
        //doNotChange_List(copyOfNames);
        System.out.println(copyOfNames);

        System.out.println("Immutability for Set");
        Set<String>setOfNames = new HashSet<>(names);
        doNotChange_Set(setOfNames);
        System.out.println(setOfNames);

        Set<String> copyOfSetOfNames = Set.copyOf(setOfNames);
        //doNotChange_Set(copyOfSetOfNames);
        System.out.println(copyOfSetOfNames);

        System.out.println("Immutability for Map");

        Map<Integer,String> mapOfNames = convertListBeforeJava8(setOfNames);
        doNotChange_Map(mapOfNames);
        System.out.println(mapOfNames);
        mapOfNames = Map.copyOf(mapOfNames);
        //doNotChange_Map(mapOfNames);
        System.out.println(mapOfNames);
    }

    private static void doNotChange_List(List<String> names) {
        names.add("changed");
    }
    private static void doNotChange_Set(Set<String> setOfNames) {
        setOfNames.add("changed");
    }
    private static void doNotChange_Map(Map<Integer, String> mapOfNames) {
        mapOfNames.put(4,"changed");
    }
    private static Map<Integer, String> convertListBeforeJava8(Set<String> list) {
        Map<Integer, String> map = new HashMap<>();
        /*
        int count = 0;
        for (String str : list) {
            count++;
//            map.put(count, str);
            map.put(str.length(), str);
        }
        */
        map = list.stream().collect(Collectors.toMap(str->str.length()+1,Function.identity()));
        return map;
    }


}
