package functional.java_8_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduce {
    public static int performMultiplication(List<Integer>integerList){
        return integerList
                .stream()
                /*
                 1
                 3
                 5
                 7
                 a=1,b=1 => result 1 is returned
                 a=1,b=3 => result 3 is returned
                 a=3,b=5 => result 15 is returned
                 a=15,b=7 => result 105 is returned
                 */
                .reduce(1,(a,b) -> a*b);
    }
    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer>integerList){
        return integerList
                .stream()
                 /*
                 1
                 3
                 5
                 7
                  */
                .reduce((a,b) -> a*b);
    }
    public static Optional<Student> getHighestGPAStudent(){
       return StudentDataBase.getAllStudents()
                .stream()
               /*
                .reduce( (s1,s2) -> {
                    if(s1.getGpa() > s2.getGpa()){
                        return s1;
                    }else{
                        return s2;
                    }
                    });
                    */
               .reduce( (s1,s2) -> (s1.getGpa()>s2.getGpa()?s1:s2));
    }
    public static int noOfNoteBooks(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGradeLevel()>=3)
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoteBooks)
                //.reduce(0,(a,b)->a+b);
                .reduce(0,Integer::sum);
    }
    public static void main(String[] args) {
        List<Integer>integerList = List.of(1,3,5,7);
        System.out.println(performMultiplication(integerList));
        System.out.println(performMultiplicationWithoutIdentity(integerList));
        Optional<Student>studentOptional = getHighestGPAStudent();
        if(getHighestGPAStudent().isPresent()){
            System.out.println(studentOptional.get());
        }

        System.out.println("noOfNotebooks:"+noOfNoteBooks());

        System.out.println("reduce() Flavors and Examples");

        System.out.println("1.reduce() whose Result is the Same Type as the Stream's Elements");
        System.out.println("T reduce(T identity, BinaryOperator<T> accumulator)");
        IntStream intStream = IntStream.of(11, 22, 33, 44, 55);
        int sum = intStream.reduce(0,(a,b)->a+b);
        System.out.println("sum:"+sum);
        /*
        int max = intStream.reduce(0,Integer::max);
        System.out.println("max:"+max);
        int min = intStream.reduce(0,Integer::min);
        System.out.println("min:"+min);
        Stream stringStream = Stream.of("Java", "Python", "JavaScript");
        int sumOfLengths = stringStream.mapToInt(String::length)
                .reduce(0, Integer::sum);
        System.out.println("sumOfLengths:"+sumOfLengths);
        */
        System.out.println("2. reduce() whose Result is an Optional");
        System.out.println("Optional<T> reduce(BinaryOperator<T> accumulator)");
        List<String> langs = List.of("Java", "Python", "JavaScript");

        Optional longest = langs.stream().reduce(
                (s1, s2) -> (s1.length() > s2.length()) ? s1 : s2);
        System.out.println("longest:"+longest);

        System.out.println("3.reduce() which Uses a Combining Function");
        System.out.println("<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)");
        String string = "Our Mathematical Universe: My Quest for the Ultimate Nature of Reality";
        List<String> wordList = List.of(string.split(" "));
        System.out.println(wordList);
        int length = wordList.stream()
                .reduce(0,
                 (parLength,word) -> parLength+word.length(),
                 (parLength,otherParLength)->parLength+otherParLength
                 );
        System.out.println(String.format("The sum length of all the words in the paragraph is %d", length));

        Stream<Integer> numbersStream = Arrays.asList(12, 13, 14, 15, 16, 17).stream();
        List<Integer> numbersList = numbersStream.reduce(
                // Identity
                new ArrayList<>(),
                // Accumulator
                (list, number) -> {
                    list.add(number);
                    return list;
                },
                // Combiner
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }
        );
        System.out.println(numbersList);

        // for more detail
        //https://javadevcentral.com/java-stream-reduce
        //https://www.techiedelight.com/java-8-stream-reduce-method-code-examples/
        //http://www.java2s.com/Tutorials/Java/Java_Stream/0230__Java_Stream_Reduce.htm
        //https://www.javabrahman.com/java-8/java-8-reducing-with-streams-reduce-method-tutorial-with-examples/
        // https://stackabuse.com/java-8-streams-guide-to-reduce/
    }
}
