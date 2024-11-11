package functional.dp.creational.singleton.threadsafe;

public class ThreadSafeDoubleCheckLockingSingleton {

    private static ThreadSafeDoubleCheckLockingSingleton INSTANCE;

    private ThreadSafeDoubleCheckLockingSingleton(){}

    public static synchronized ThreadSafeDoubleCheckLockingSingleton getInstance(){
        if (INSTANCE == null){
            synchronized(ThreadSafeSingleton.class){
                if (INSTANCE == null){
                    INSTANCE = new ThreadSafeDoubleCheckLockingSingleton();
                }
            }

        }
        return INSTANCE;
    }
}

