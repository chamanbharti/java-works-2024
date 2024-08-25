package annotation.controller;

import annotation.service.Pizza;
import annotation.service.VegPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Component
//@Component("demoPizza")
public class ComponentAndAutowired {

    // 3rd approach
    //@Autowired //here annotation is mandatory
    private Pizza pizza;
    // 1st approach
    // @Autowired this annotation here is optional
    public ComponentAndAutowired(Pizza pizza){
        this.pizza = pizza;
    }

    // 2nd approach
    /*
    public VegPizza getVegPizza() {
        return vegPizza;
    }
    @Autowired // here annotation is mandatory
    public void setVegPizza(VegPizza vegPizza) {
        this.vegPizza = vegPizza;
    }
    */
    public String getPizza(){
        return pizza.getPizza();
    }

    public void init(){
        System.out.println("Initialization logic");
    }
    public void destroy(){
        System.out.println("Destruction logic");
    }
}
