package features.java8.lambda;

interface A{
    public void methodOne();
}
class B implements A{
    public void methodOne(){
        System.out.println("methodOne executed");
    }
}

public class Lambda1 {
    public static void main(String[] args) {
        // without lambda
        A a = new B();
        a.methodOne();

        // with lambda
        A b = () -> System.out.println("methodOne executed");
        b.methodOne();
    }

}
