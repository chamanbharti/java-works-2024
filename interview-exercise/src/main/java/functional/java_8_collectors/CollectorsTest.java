package functional.java_8_collectors;


import functional.model.Student;

import java.util.*;
import java.util.stream.Collectors;
// https://javaconceptoftheday.com/java-8-collectors-tutorial/
public class CollectorsTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(8, 2, 5, 7,7, 3, 6);
        System.out.println("collect() method returning List of OddNumbers");

        List<Integer> toList = numbers.stream().filter(i -> i%2 !=0).collect(Collectors.toList());
        System.out.println("toList:"+toList);


        List<Integer> toCollection = numbers.stream().filter(i -> i%2 !=0).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("toCollection:"+toCollection);

        Set<Integer> toSet = numbers.stream().filter(i -> i%2 !=0).collect(Collectors.toSet());
        System.out.println("toSet:"+toSet);

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));

        System.out.println("Collecting top 3 performing students into List");
        List<Student> top3Students = studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .limit(3).collect(Collectors.toList());
        System.out.println("top3Students:"+top3Students);

        System.out.println("Collecting subjects offered into Set.");
        Set<String> subjects = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
        System.out.println("subjects:"+subjects);

        System.out.println("Collecting name and percentage of each student into a Map");
        Map<String,Double> namePercentageMap = studentList
                .stream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));
        System.out.println("namePercentageMap:"+namePercentageMap);

        System.out.println("Collecting first 3 students into LinkedList");
        List<Student> studentLinkedList = studentList
                .stream()
                .limit(3)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("studentLinkedList:"+studentLinkedList);

        System.out.println("Collecting the names of all students joined as a string");
        String namesJoined = studentList
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("namesJoined:"+namesJoined);

        System.out.println("Counting number of students.");
        Long studentCount = studentList.stream().count();
        System.out.println("studentCount:"+studentCount);
        studentCount = studentList.stream().collect(Collectors.counting());
        System.out.println("studentCount2:"+studentCount);

        System.out.println("Collecting highest percentage.");
        Optional<Double> highPercentage = studentList
                .stream()
                .map(Student::getPercentage)
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println("highPercentage:"+highPercentage);

        System.out.println("Collecting lowest percentage.");
        Optional<Double> lowPercentage = studentList
                .stream()
                .map(Student::getPercentage)
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("lowPercentage:"+lowPercentage);

        System.out.println("summingInt(), summingLong(), summingDouble()");
        System.out.println("Collecting sum of percentages");
        Double sumOfPercentages = studentList.stream()
                .collect(Collectors.summingDouble(Student::getPercentage));
        System.out.println("sumOfPercentages:"+sumOfPercentages);

        System.out.println("averagingInt(), averagingLong(), averagingDouble()");
        System.out.println("Collecting average percentage");
        Double averageOfPercentages = studentList.stream()
                .collect(Collectors.averagingDouble(Student::getPercentage));
        System.out.println("averageOfPercentages:"+averageOfPercentages);

        System.out.println("summarizingInt(), summarizingLong(), summarizingDouble()");
        System.out.println("Extracting highest, lowest and average of percentage of students");
        DoubleSummaryStatistics studentStats = studentList.stream()
                .collect(Collectors.summarizingDouble(Student::getPercentage));
        System.out.println(studentStats);
        // studentStats{count=10, sum=815.000000, min=71.500000, average=81.500000, max=92.800000}
        System.out.println("studentCount : "+studentStats.getCount());
        System.out.println("Highest Percentage : "+studentStats.getMax());
        System.out.println("Lowest Percentage : "+studentStats.getMin());
        System.out.println("sumOfPercentages : "+studentStats.getSum());
        System.out.println("averageOfPercentages : "+studentStats.getAverage());

        System.out.println("Collectors.groupingBy() :");
        System.out.println("Grouping the students by subject");
        Map<String,List<Student>> studentsGroupedBySubject = new HashMap<>();
        studentsGroupedBySubject = studentList.stream()
                .collect(Collectors.groupingBy(Student::getSubject));
        System.out.println("studentsGroupedBySubject:"+studentsGroupedBySubject);
        studentsGroupedBySubject = new HashMap<>();
        List<Student> list = new ArrayList<>();

        for (Student student:studentList){
            String subject = student.getSubject();
            Student student1 = new Student();
            student1.setId(student.getId());
            student1.setName(student.getName());
            student1.setSubject(student.getSubject());
            student1.setPercentage(student.getPercentage());
            list.add(student1);
            studentsGroupedBySubject.put(subject,list);
        }
        System.out.println("studentsGroupedBySubject2:"+studentsGroupedBySubject);

        System.out.println("Collectors.partitioningBy() :");
        System.out.println("Partitioning the students who got above 80.0% from who don’t.");
        Map<Boolean, List<Student>> studentspartionedByPercentage = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getPercentage() > 80.0));
        System.out.println("studentspartionedByPercentage:"+studentspartionedByPercentage);

        System.out.println("Collectors.collectingAndThen() :");
        System.out.println("Collecting first three students into List and making it unmodifiable");
        List<Student> first3Students = studentList.stream()
                .limit(3)
                .collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
        //first3Students.add(new Student("Harry", 20, "History", 71.9)); //UnsupportedOperationException
        System.out.println("first3Students:"+first3Students);
    }
}
