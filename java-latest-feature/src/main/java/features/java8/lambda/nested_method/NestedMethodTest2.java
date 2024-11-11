package features.java8.lambda.nested_method;

/**
 * Using Inner Classes
 */
class OuterClass{
    void outerMethod(){
        System.out.println("OuterClass method");

        class InnerClass{
            void innerMethod(){
                System.out.println("InnerClass method");
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }
}
public class NestedMethodTest2 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
