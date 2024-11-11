package functional.dp.creational.singleton.Enum;

public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.getInstance();
        EnumSingleton instance2 = EnumSingleton.getInstance();
        //EagerLoading instance1 = EagerLoading.getInstance();
        System.out.println(instance1.hashCode());;
        System.out.println(instance2.hashCode());;
    }
}
