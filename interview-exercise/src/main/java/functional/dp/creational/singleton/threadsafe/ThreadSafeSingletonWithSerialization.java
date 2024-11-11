package functional.dp.creational.singleton.threadsafe;

import java.io.Serializable;

public class ThreadSafeSingletonWithSerialization  implements Serializable {
    private static final long serialVersionUID = 5L;
    private static ThreadSafeSingletonWithSerialization INSTANCE;

    private ThreadSafeSingletonWithSerialization(){}

    public static synchronized ThreadSafeSingletonWithSerialization getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ThreadSafeSingletonWithSerialization();
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

