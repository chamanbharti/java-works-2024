package functional.dp.creational.singleton.threadsafe;

import java.io.Serializable;

public class BillPughSingletonWithSerialization implements Serializable {
    private static final long serialVersionUID = 5L;
    private BillPughSingletonWithSerialization(){}
    private static class SingletonHelper{
        private static final BillPughSingletonWithSerialization INSTANCE = new BillPughSingletonWithSerialization();
    }
    public static BillPughSingletonWithSerialization getInstance(){
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
