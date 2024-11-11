package features.java8.lambda;
interface E{
    public int square(int x);
}
class Demo implements E{
    public int square(int x){
        return x*x;
    }
}
public class Lambda3 {
    public static void main(String[] args) {
        // without lambda
        E e = new Demo();
        System.out.println("The square of given no is :"+e.square(5));
        // with lambda
        E e1 = (x)->x*x;
        System.out.println("The square of given no is :"+e.square(7));
    }
}
