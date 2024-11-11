package functional.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {
    // Dog times(); // can't use wrapper class
   // int times();
    //int[] times();
    int times() default 3;
}
