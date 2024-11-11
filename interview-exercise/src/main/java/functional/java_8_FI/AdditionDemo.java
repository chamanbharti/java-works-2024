package functional.java_8_FI;

public class AdditionDemo implements Addition{
    public static void main(String[] args) {

        System.out.println("first approach");
        AdditionImpl addition = new AdditionImpl();
        System.out.println(addition.add(1,3));

        System.out.println("second approach");
        //System.out.println(new AdditionDemo().add(1,3));
        AdditionDemo additionDemo = new AdditionDemo();
        System.out.println(additionDemo.add(1,3));

        System.out.println("third approach");
        Addition addition1 = (a,b) -> a+b;
        System.out.println(addition1.add(4,5));

    }

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
