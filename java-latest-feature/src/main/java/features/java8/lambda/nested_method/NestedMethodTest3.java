package features.java8.lambda.nested_method;
/**
 * Using Local Classes
 */
class LocalClass {
    void methodWithLocalClass() {
        class Local{
            void display(){
                System.out.println("Inside Local class method");

            }
        }
        Local local = new Local();
        local.display();
    }
}
public class NestedMethodTest3 {
    public static void main(String[] args) {
        LocalClass lc = new LocalClass();
        lc.methodWithLocalClass();
    }
}
