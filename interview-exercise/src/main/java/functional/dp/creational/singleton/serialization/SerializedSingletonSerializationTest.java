package functional.dp.creational.singleton.serialization;

import functional.dp.creational.singleton.serialize.SerializedSingleton;

import java.io.*;

public class SerializedSingletonSerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("BillPughSingletonWithSerialization");
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceOne hashCode="+instanceTwo.hashCode());

        System.out.println(instanceOne.hashCode()==instanceTwo.hashCode());
    }
}
