package functional.java_8_lambda;
interface Interface1 {
    public void methodOne();
}
class Demo implements Interface1{

    @Override
    public void methodOne() {
        System.out.println("method one execution");
    }
}
public class Test {
    public static void main(String[] args) {
        Interface1 obj = new Demo();
        obj.methodOne();
    }
}
