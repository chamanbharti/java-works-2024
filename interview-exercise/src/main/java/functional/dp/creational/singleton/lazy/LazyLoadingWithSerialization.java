package functional.dp.creational.singleton.lazy;

import java.io.Serializable;

public class LazyLoadingWithSerialization implements Serializable {
    private static final long serialVersionUID = 5L;
    private static LazyLoadingWithSerialization INSTANCE;

    private LazyLoadingWithSerialization(){}

    public static LazyLoadingWithSerialization getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazyLoadingWithSerialization();
        }
        return INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

