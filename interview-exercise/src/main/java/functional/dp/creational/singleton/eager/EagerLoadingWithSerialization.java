package functional.dp.creational.singleton.eager;

import java.io.Serializable;

public class EagerLoadingWithSerialization implements Serializable {
    private static final long serialVersionUID = 5L;

    private static  final EagerLoadingWithSerialization INSTANCE = new EagerLoadingWithSerialization();

    private EagerLoadingWithSerialization(){}

    public static EagerLoadingWithSerialization getInstance(){
        return INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}

