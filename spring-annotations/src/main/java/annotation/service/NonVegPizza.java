package annotation.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class NonVegPizza implements Pizza{
    public String getPizza(){
        return "Non Veg Pizza!";
    }
}
