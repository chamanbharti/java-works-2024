package functional.java_8_FI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {
    /*
    @Override
    public String get() {
        return "list is empty";
    }
     */

    @Override
    public String get() {
        return "list is empty";
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList();

        System.out.println("first approach");
        SupplierDemo supplierDemo = new SupplierDemo();
        if (list.isEmpty()){
            System.out.println(supplierDemo.get());
        }

        System.out.println("second approach");
        //System.out.println(list.stream().findAny().orElseGet( () -> "list is empty"));
        System.out.println(list.stream().findAny().orElse("list is empty"));
    }

}
