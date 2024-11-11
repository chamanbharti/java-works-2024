package functional.dp.creational.singleton.eager;

public class EagerLoading {

    private static  final EagerLoading INSTANCE = new EagerLoading();

    private EagerLoading(){}

    public static EagerLoading getInstance(){
        return INSTANCE;
    }
    public static void main(String[] args) {
        EagerLoading instance1 = EagerLoading.getInstance();
        EagerLoading instance2 = EagerLoading.getInstance();
        //EagerLoading instance1 = EagerLoading.getInstance();
        System.out.println(instance1.hashCode());;
        System.out.println(instance2.hashCode());;
    }
}

