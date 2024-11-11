package functional.dp.creational.singleton.reflection;

import functional.dp.creational.singleton.lazy.LazyLoading;

import java.lang.reflect.Constructor;

public class ReflectionLazySingletonTest {
    public static void main(String[] args) {
        LazyLoading instanceOne = LazyLoading.getInstance();
        LazyLoading instanceTwo = null;
        try {
            Constructor[] constructors = LazyLoading.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazyLoading)constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
