package functional.java.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationDemo1 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat("Stella");
        Dog dog = new Dog("Jerry");
       if(cat.getClass().isAnnotationPresent(VeryImportant.class)){
           System.out.println("this is very important");
       }else{
           System.out.println("this is not very important");
       }
       for(Method method: cat.getClass().getDeclaredMethods()){
           System.out.println("call method");
           if(method.isAnnotationPresent(RunImmediately.class)){
               method.invoke(cat);
           }
           System.out.println("call no of times any method");
           if(method.isAnnotationPresent(RunImmediately.class)){
               RunImmediately annotation = method.getAnnotation(RunImmediately.class);
               for(int i=0;i< annotation.times();i++){
                   method.invoke(cat);
               }
           }
       }

       for (Field field:cat.getClass().getDeclaredFields()){
           if(field.isAnnotationPresent(ImportantString.class)){
               Object objectValue = field.get(cat);
//               if(objectValue instanceof String){
//                   System.out.println(objectValue);
//               }
//               if(objectValue instanceof String stringValue){
//                   System.out.println(stringValue);
//               }
           }
       }
    }

}
