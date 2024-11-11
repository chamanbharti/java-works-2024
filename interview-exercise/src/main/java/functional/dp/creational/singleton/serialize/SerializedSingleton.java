package functional.dp.creational.singleton.serialize;

import java.io.*;

public class SerializedSingleton implements Serializable{
    private static final long serialVersionUID = -76047177L;

    private SerializedSingleton(){}
    private static class SingletonHelper{
        private static SerializedSingleton INSTANCE = new SerializedSingleton();
    }
    public static SerializedSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
