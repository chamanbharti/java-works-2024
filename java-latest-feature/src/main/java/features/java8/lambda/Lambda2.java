package features.java8.lambda;

interface C{
    public void sum(int a, int b);
}
class D implements C{
    public void sum(int a, int b){
        System.out.println("The sum:"+a+b);
        System.out.println(a+b+" is the sum of given no");
    }
}

public class Lambda2 {
    public static void main(String[] args) {
        // without lambda
        C c = new D();
        c.sum(1, 2);

        // with lambda
        C c2 = (a,b) -> System.out.println(a+b);
        c2.sum(1, 2);

    }

}
