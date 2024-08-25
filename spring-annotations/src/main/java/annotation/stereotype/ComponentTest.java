package annotation.stereotype;

import org.springframework.stereotype.Component;

@Component
public class ComponentTest {
    public String hello(){
        return "Hello ComponentTest";
    }
}
