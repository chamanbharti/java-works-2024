package functional.java_8_streams;

import java.util.Optional;

public class StreamFindFirstAny {
    public static Optional<Student> findAny(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>3.9)
                .findAny();
    }
    public static Optional<Student> findFirst(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>3.5)
                .findFirst();
    }
    public static void main(String[] args) {
        Optional<Student>studentFindAny = findAny();
        if (studentFindAny.isPresent()){
            System.out.println("Found the student:"+studentFindAny.get());
        }else {
            System.out.println("Student not found");
        }

        Optional<Student>studentFindFirst = findFirst();
        if (studentFindFirst.isPresent()){
            System.out.println("Found the student:"+studentFindAny.get());
        }else {
            System.out.println("Student not found");
        }
    }
}
