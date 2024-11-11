package functional.java_8_streams;

import java.util.stream.Stream;

public class ExcludeListsWithStream {
    public static void main(String[] args) {
//        var fileName = "info.java";
//        var endings = Stream.of(".dll",".yaml",".java");
       /*
        var doesnEndWith = endings
                .filter(ending -> fileName.endsWith(ending))
                .findFirst()
                .isEmpty();
        System.out.println(doesnEndWith);
        */

        //one liner
//       var doesnEndWith = endings
//                .noneMatch(ending -> fileName.endsWith(ending));
//        System.out.println(doesnEndWith);
    }
    /*
        meter reading
        date:26-04-23 - 7265
             31-03-23 - 6933 diff 332
             april 23 - 332
             mar  23  - 1006
             jan 23   - 1082
           total unit - 2420

     */
}
