package functional.dp.creational.singleton.cloning;

import functional.dp.creational.singleton.eager.SingletonWithClone;

public class CloneEagerLoading {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonWithClone instance1 = SingletonWithClone.getInstance();
        SingletonWithClone instance2 = (SingletonWithClone) instance1.clone();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

