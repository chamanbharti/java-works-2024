package functional.dp.creational.singleton.eager;

public class SingletonWithClone implements Cloneable{
    private SingletonWithClone(){}
    private static class SingletonHelper{
        private static  final SingletonWithClone INSTANCE = new SingletonWithClone();
    }

    public static SingletonWithClone getInstance(){
        return SingletonHelper.INSTANCE;
    }

    /*
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    */
    // to prevent cloning the object
    @Override
    public Object clone() throws CloneNotSupportedException {
        //return getInstance();
        throw new CloneNotSupportedException();
    }
}

