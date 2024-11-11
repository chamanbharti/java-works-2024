package functional.java_8_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsTest {

    public static void main(String[] args) {

        IntStream.of(new int[] {4, 7, 1, 8, 3, 9, 7})
                .filter((int i) -> i > 5)
                .distinct()
                .forEach(System.out::println);

        List<String> names = new ArrayList<>();

        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");
//        names.stream()
        names.parallelStream()
                .filter( (String name) -> name.length() > 5)
                .skip(2)
                .forEach(System.out::println);

        System.out.println("demo");
//       Map<String,List<String>> studentMap =
//        StudentDataBase.getAllStudents().stream()
//        .collect(Collectors.toMap(Student::getName,Student::getActivities));
//        System.out.println(studentMap);

//        Map<String,List<String>> studentMap =
//                StudentDataBase.getAllStudents().stream()
//                .filter(student -> student.getGradeLevel() >= 3)
//                .collect(Collectors.toMap(Student::getName,Student::getActivities));
//        System.out.println(studentMap);

//        Predicate<Student> studentPredicate = (student -> student.getGradeLevel() >= 3);
//        Map<String,List<String>> studentMap =
//                StudentDataBase.getAllStudents().stream()
//                        .filter(studentPredicate)
//                        .collect(Collectors.toMap(Student::getName,Student::getActivities));
//        System.out.println(studentMap);

        Predicate<Student> studentPredicate = (student -> student.getGradeLevel() >= 3);
        Predicate<Student> studentGPAPredicate = (student -> student.getGpa() >= 3.9);
        Map<String,List<String>> studentMap =
                StudentDataBase.getAllStudents().stream()
                        .peek(student -> System.out.println("before filter:"+student))
                .filter(studentPredicate)
                        .peek(student -> System.out.println("after filter1:"+student))
                .filter(studentGPAPredicate)
                        .peek(student -> System.out.println("after filter2:"+student))
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentMap);

        System.out.println("character from a string");
        String str = "Cognizant";
        char ch = str.charAt(3);
        System.out.println(ch);
        System.out.println("Using Java 8 Streams:");
        System.out.println(str.chars()
                .mapToObj(c->(char)c)
                .toArray(Character[]::new)[3]);



    }
}
