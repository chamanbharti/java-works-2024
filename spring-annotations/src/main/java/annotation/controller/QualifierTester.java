package annotation.controller;

import annotation.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierTester {
    private Pizza pizza;
    @Autowired
    public QualifierTester(@Qualifier("nonVegPizza") Pizza pizza){
        this.pizza=pizza;
    }

    public String getPizza(){
        return pizza.getPizza();
    }
}
