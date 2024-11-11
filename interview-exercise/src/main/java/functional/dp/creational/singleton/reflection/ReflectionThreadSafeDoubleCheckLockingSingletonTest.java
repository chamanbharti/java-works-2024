package functional.dp.creational.singleton.reflection;

import functional.dp.creational.singleton.threadsafe.ThreadSafeDoubleCheckLockingSingleton;

import java.lang.reflect.Constructor;

public class ReflectionThreadSafeDoubleCheckLockingSingletonTest {
    public static void main(String[] args) {
        ThreadSafeDoubleCheckLockingSingleton instanceOne = ThreadSafeDoubleCheckLockingSingleton.getInstance();
        ThreadSafeDoubleCheckLockingSingleton instanceTwo = null;
        try {
            Constructor[] constructors = ThreadSafeDoubleCheckLockingSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (ThreadSafeDoubleCheckLockingSingleton)constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
