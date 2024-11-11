package functional.java_8_map_vs_flatmap;

import functional.java_8_streams.Student;
import functional.java_8_streams.StudentDataBase;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://javaconceptoftheday.com/differences-between-java-8-map-and-flatmap/
public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
        instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        //Java 8 Map() : Get names of all institutes
        // It is a One-To-One mapping.
        List<String> nameOfInstitutes = new ArrayList<>();
        for (Institute str:instituteList){
            nameOfInstitutes.add(str.getName());
        }
        System.out.println("nameOfInstitutes1:"+nameOfInstitutes);// [IIM, IIT, NIFT]
        nameOfInstitutes = instituteList.stream().map(Institute::getName).collect(Collectors.toList());
        System.out.println("nameOfInstitutes2:"+nameOfInstitutes);// [IIM, IIT, NIFT]

        //Java 8 FlatMap() : Get unique locations of all institutes
        // It is a One-To-Many mapping.
        Set<String>locationOfInstitutes = new HashSet<>();
        for (Institute str:instituteList){
            for (String str2:str.getLocations()){
                locationOfInstitutes.add(str2);
            }
        }
        System.out.println("locationOfInstitutes1:"+locationOfInstitutes);
        locationOfInstitutes = instituteList.stream()
                .flatMap(institute->institute.getLocations().stream())
                .collect(Collectors.toSet());
        System.out.println("locationOfInstitutes2:"+locationOfInstitutes);// [Ahmedabad, Lucknow, Delhi, Patna, Kozhikode, Kharagpur, Mumbai, Hyderabad, Bangalore]

        // Map stream operation is generally used for simple operation on Stream
        List<String> names = Arrays.asList("Chaman","Bharti","Roshan","Parveen");
        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());;
        System.out.println("upperNames:"+upperNames);

        // FlatMap stream operation is used for more complex stream operation
        List<List<String>> names2 = Arrays.asList(
                Arrays.asList("Chaman","Bharti"),
                Arrays.asList("Sahil","Bharti"),
                Arrays.asList("Aman","Bharti")
        );
        System.out.println("names2:"+names2);
        List<String> FlatMap = names2.stream()
                //.flatMap(name->name.stream())
                .flatMap(Collection::stream)
                //.filter(s->s.startsWith("C"))
                .collect(Collectors.toList());
        System.out.println("FlatMap:"+FlatMap);

        String s = "This is a";
        String s2 = "flatMap example";
        List<String> result = Stream.of(s,s2)
                .flatMap(str->Stream.of(str.split(" ")))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("result:"+result);

        System.out.println("Demo Map and FlatMap again");
        List<String> studentList = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                // .collect(Collectors.toList());
                .toList();
        System.out.println("studentList:"+studentList);
        Set<String> studentSet = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println("studentSet:"+studentSet);

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                //.collect(Collectors.toList());
                .distinct()
                .sorted()
                .toList();
        System.out.println("studentActivities:"+studentActivities);

        long noOfStudentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                //.collect(Collectors.toList());
                .distinct()
                .count();
        System.out.println("noOfStudentActivities:"+noOfStudentActivities);

        System.out.println("Sorted by student name");
        List<Student>sortedByStudentName = StudentDataBase
                .getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("sortedByStudentName:");
        sortedByStudentName.forEach(System.out::println);

        List<Student>sortedByStudentNameDesc = StudentDataBase
                .getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName).reversed())
                .collect(Collectors.toList());
        System.out.println("sortedByStudentNameDesc:");
        sortedByStudentNameDesc.forEach(System.out::println);
    }
}
