package functional.java_8_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// thana-pahladpur
public class JavaIODemo {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\2230849\\opening SO.txt";
        List<String> list = new ArrayList<>();
        /*
        try(Stream<String> stream = Files.lines(Paths.get(filePath))){
            //stream.forEach(System.out::println);
            list = stream.map(String::toUpperCase).collect(Collectors.toList());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        */

        /*
        try(BufferedReader br = Files.newBufferedReader(Paths.get(filePath))){
            list = br.lines().collect(Collectors.toList());
        }catch (IOException ex){
            ex.printStackTrace();
        }
        list.forEach(System.out::println);
         */
        Path path = Paths.get(filePath);
        try(Stream<String> stream = Files.lines(path)){
            stream.forEach(System.out::println);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
