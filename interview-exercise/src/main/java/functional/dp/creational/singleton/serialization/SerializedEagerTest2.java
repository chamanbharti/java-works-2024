package functional.dp.creational.singleton.serialization;

import functional.dp.creational.singleton.eager.EagerLoading;

import java.io.*;

public class SerializedEagerTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        EagerLoading instanceOne = EagerLoading.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        deserialize(instanceOne);
    }
    //deserailize from file to object
    public static <E> void deserialize(E input) throws IOException, ClassNotFoundException {
        System.out.println("input class:"+input.getClass().getSimpleName());
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        E instanceTwo = (E) in.readObject();
        in.close();
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
    }
}
