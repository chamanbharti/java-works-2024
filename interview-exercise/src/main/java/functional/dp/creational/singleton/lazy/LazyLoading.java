package functional.dp.creational.singleton.lazy;

public class LazyLoading {

    private static LazyLoading INSTANCE;

    private LazyLoading(){}

    public static LazyLoading getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazyLoading();
        }
        return INSTANCE;
    }
}

