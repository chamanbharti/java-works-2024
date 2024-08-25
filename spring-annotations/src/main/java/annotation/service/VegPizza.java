package annotation.service;

import org.springframework.stereotype.Component;

//@Component()
public class VegPizza implements Pizza{
    public String getPizza(){
        return "Veg Pizza!";
    }
}
