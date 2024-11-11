package functional.dp.creational.singleton.eager;

public class SingletonWithException{
    private static final SingletonWithException INSTANCE;
    private SingletonWithException(){}
    static {
        try {
            INSTANCE = new SingletonWithException();
        }catch (Exception ex){
            throw new RuntimeException("Exception caught in creating instance");
        }
    }
    public static SingletonWithException getInstance(){
        return INSTANCE;
    }

}
