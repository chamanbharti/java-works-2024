package annotation.stereotype;

import org.springframework.stereotype.Controller;

@Controller
public class ControllerTest {
    public String hello(){
        return "Hello ControllerTest";
    }
}
