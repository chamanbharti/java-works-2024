package functional.java.annotation;

public class Dog {
    String name;
    int age;
    public Dog(String name){
        this.name = name;
    }

    @VeryImportant
    public void meow(){
        System.out.println("Meow!");
    }
    public void eat(){
        System.out.println("Munch!");
    }
}
