package features.java8.lambda;
interface Impl{
    public void m1();
}
public class Lambda6 {
    int x = 77;
    public void m2(){
        Impl i = () -> {
            int x = 88;
            System.out.println(x);//88
            System.out.println(this.x);//77
        };

        i.m1();
    }
    public static void main(String[] args) {
     Lambda6 l = new Lambda6();
     l.m2();
    }
}
