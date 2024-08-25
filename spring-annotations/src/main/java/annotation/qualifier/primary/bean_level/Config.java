package annotation.qualifier.primary.bean_level;

import annotation.controller.ComponentAndAutowired;
import annotation.service.NonVegPizza;
import annotation.service.Pizza;
import annotation.service.VegPizza;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
/**
 If we try to load FooService into our context,
 the Spring framework will throw a NoUniqueBeanDefinitionException.
 This is because Spring doesn’t know which bean to inject.
 To avoid this problem, there are several solutions;
 the @Qualifier annotation is one of them.
 */
@Configuration
//@Lazy // when need below all beans on demand
public class Config {

    @Bean
    @Primary
    //@Lazy // for only this bean on demand
    public Employee johnEmployee() {
        return new Employee("John");
    }

    @Bean
    @Qualifier("tonyEmployee")
    public Employee tonyEmployee() {
        return new Employee("Tony");
    }
    // first approach
    // second approach you should use @Qualifier annotation level

    @Bean
    public Interest sbi(){
        return new SBI();
    }
    @Bean
    public Interest hdfc(){
        return new HDFC();
    }
    @Bean
    public Pizza nonVegPizza(){
        return new NonVegPizza();
    }
    @Bean
    public Pizza vegPizza(){
        return new VegPizza();
    }
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public ComponentAndAutowired componentAndAutowired(){
        return new ComponentAndAutowired(nonVegPizza());
    }
}
