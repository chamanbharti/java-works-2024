package functional.dp.creational.singleton.serialization;

import functional.dp.creational.singleton.lazy.LazyLoadingWithSerialization;

import java.io.*;

public class LazyLoadingSerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Lazy Singleton");
        LazyLoadingWithSerialization instanceOne = LazyLoadingWithSerialization.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        LazyLoadingWithSerialization instanceTwo = (LazyLoadingWithSerialization) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceOne hashCode="+instanceTwo.hashCode());

        System.out.println(instanceOne.hashCode()==instanceTwo.hashCode());
    }

}
