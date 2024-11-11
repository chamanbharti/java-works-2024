package functional.dp.creational.singleton.Enum;

import java.io.Serializable;

public enum EnumSingletonWithSerialization implements Serializable {

    INSTANCE;
    private static final long serialVersionUID = 5L;
    public static EnumSingletonWithSerialization getInstance(){
        return INSTANCE;
    }
}
