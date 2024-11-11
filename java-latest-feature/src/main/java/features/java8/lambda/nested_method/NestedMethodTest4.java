package features.java8.lambda.nested_method;

import java.util.Arrays;
import java.util.List;

/**
 * Using Lambda Expressions
 */
public class NestedMethodTest4 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> {
            // This is effectively a nested "method"
            System.out.println("Hello,"+name);
        });
    }
}
