package functional.java.annotation;
@VeryImportant
public class Cat {

    @ImportantString
    String name;
    int age;
    public Cat(String name){
        this.name = name;
    }

    @VeryImportant
    @RunImmediately//(times = 3)
    public void meow(){
        System.out.println("Meow!");
    }

    public void eat(){
        System.out.println("Munch!");
    }
}
