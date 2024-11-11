package functional.java_8_FI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpecificNumberContain {
    public static void main(String[] args) {
        List<String> list = Stream.of("500100",
                "500103",
                "500600",
                "501502",
                "508400").collect(Collectors.toList());
        for (String i:list){
            if(i.contains("85")){
                System.out.println("officeCode:"+i);
            }
        }
        list.stream().sorted().forEach(System.out::println);
        //System.out.println(list.stream().sorted().filter(i->i.contains("84")).findFirst().orElse("no value"));
    }

}
