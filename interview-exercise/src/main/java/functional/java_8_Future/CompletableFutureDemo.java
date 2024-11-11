package functional.java_8_Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class CompletableFutureDemo {
    static String greet(){
        return "Merry Xmas";
    }
    static String decorate(String input){
        return String.format("**%s**",input);
    }
    static void print(String message){
        System.out.println(message);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        CompletableFuture
                .supplyAsync(CompletableFutureDemo::greet)
                .thenApply(CompletableFutureDemo::decorate)
                .thenAccept(CompletableFutureDemo::print);
        */
        Supplier<String> greet = () -> "Merry Xmas";
        Function<String,String> decorate = (input) -> String.format("**%s**",input);
        Consumer<String> print = System.out::println;
        CompletableFuture.supplyAsync(greet)
                .thenApply(decorate)
                .thenAccept(print).get();
    }
}
