package functional.dp.creational.singleton.threadsafe;

import java.io.Serializable;

public class ThreadSafeDoubleCheckLockingSingletonWithSerialization  implements Serializable {
    private static final long serialVersionUID = 5L;
    private static ThreadSafeDoubleCheckLockingSingletonWithSerialization INSTANCE;

    private ThreadSafeDoubleCheckLockingSingletonWithSerialization(){}

    public static synchronized ThreadSafeDoubleCheckLockingSingletonWithSerialization getInstance(){
        if (INSTANCE == null){
            synchronized(ThreadSafeSingleton.class){
                if (INSTANCE == null){
                    INSTANCE = new ThreadSafeDoubleCheckLockingSingletonWithSerialization();
                }
            }

        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

