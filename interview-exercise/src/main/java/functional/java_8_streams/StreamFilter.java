package functional.java_8_streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {

    public static List<Student> filterStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("female"))
                .filter(student -> student.getGpa() >= 3.9)
                //.collect(Collectors.toList());
                .toList();
    }
    public static void main(String[] args) {
        System.out.println("filterStudent:");
        filterStudent().forEach(System.out::println);
    }
}
