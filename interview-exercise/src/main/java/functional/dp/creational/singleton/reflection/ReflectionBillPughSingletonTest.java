package functional.dp.creational.singleton.reflection;

import functional.dp.creational.singleton.threadsafe.BillPughSingleton;

import java.lang.reflect.Constructor;

public class ReflectionBillPughSingletonTest {
    public static void main(String[] args) {
        BillPughSingleton instanceOne = BillPughSingleton.getInstance();
        BillPughSingleton instanceTwo = null;
        try {
            Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (BillPughSingleton)constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
