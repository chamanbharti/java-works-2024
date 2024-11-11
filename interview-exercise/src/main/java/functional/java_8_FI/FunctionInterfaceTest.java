package functional.java_8_FI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionInterfaceTest {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();

        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        System.out.println("Let’s see how to use 4 important functional interfaces – Predicate, Consumer, Function and Supplier using above listOfStudents.");

        /**
         Predicate – Tests an object

         Predicate represents an operation which takes an argument T and returns a boolean. Use this functional interface,
         if you want to define a lambda expression which performs some test on an argument and returns true or false depending upon outcome of the test.

         For example,
         Imagine an operation where you want only a list of “Mathematics” students from the above listOfStudents. Let’s see how to do it using Predicate.
         Lambda expression implementing Predicate : Checking specialization of a Student
         */
        String filteredSpecialization = "Mathematics";
        System.out.println("Predicate\nChecking specialization of a Mathematics students");
        List<Student> listWhoHasMathSpecialization = new ArrayList<>();
        System.out.println("Approach I");
        for (Student student: listOfStudents){
            if (student.getSpecialization().equals(filteredSpecialization)){
                listWhoHasMathSpecialization.add(student);
            }
        }
        System.out.println(listWhoHasMathSpecialization);

        System.out.println("Approach II");
        Predicate<Student> mathematicsPredicate = (Student student) -> student.getSpecialization().equals(filteredSpecialization);
        for (Student student: listOfStudents){
            if (mathematicsPredicate.test(student)){
                listWhoHasMathSpecialization.add(student);
            }
        }
        System.out.println(listWhoHasMathSpecialization);

        System.out.println("Approach III");
        listWhoHasMathSpecialization = listOfStudents.stream().filter(row->row.getSpecialization().equals("Mathematics")).collect(Collectors.toList());
        System.out.println(listWhoHasMathSpecialization);

        /**
         Consumer – Consumes an object

         Consumer represents an operation which takes an argument and returns nothing.
         Use this functional interface If you want to compose a lambda expression which performs some operations on an object.
         For example, displaying all students with their percentage.
         Lambda expression implementing Consumer : Displaying all students with their percentage
         */
        System.out.println("Consumer\nDisplaying all students with their percentage");
        System.out.println("Approach I");
        Consumer<Student> percentageConsumer = (Student student) -> System.out.println(student.getName()+" : "+student.getPercentage());
        for (Student student: listOfStudents){
            percentageConsumer.accept(student);
        }
        System.out.println("Approach II");
        listOfStudents.forEach(student -> System.out.println(student.getName()+" : "+student.getPercentage()));

        /**
         Function – Applies to an object
         Function represents an operation which takes an argument of type T and returns a result of type R
         Use this functional interface if you want to extract some data from an existing data.
         For example, extracting only the names from listOfStudents.
         */
        List<String> studentNames = new ArrayList<>();
        System.out.println("Lambda expression implementing Function : Extracting only the names of all students");
        System.out.println("approach I");
        for (Student student:listOfStudents){
            studentNames.add(student.getName());
        }
        System.out.println(studentNames);

        System.out.println("approach II");
        // Function<Student,String> nameFunction = (Student student) -> student.getName();
        Function<Student,String> nameFunction = Student::getName;
        for (Student student:listOfStudents){
            studentNames.add(nameFunction.apply(student));
        }

        System.out.println("approach III");
        studentNames = listOfStudents.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(studentNames);

        System.out.println("approach II");

        /**
         Supplier – Supplies the objects

         Supplier represents an operation which takes no argument and returns the results of type R.
         Use this functional interface when you want to create new objects.
         Lambda expression implementing Supplier : Creating a new Student
         */
        System.out.println("Approach I");
        listOfStudents.add(new Student(1111,"Chaman",92,"Java"));
        System.out.println(listOfStudents);

        System.out.println("Approach II");
        Supplier<Student> studentSupplier = () -> new Student(1122,"Rahi",890,"IT");
        listOfStudents.add(studentSupplier.get());
        System.out.println(listOfStudents);
    }
}
