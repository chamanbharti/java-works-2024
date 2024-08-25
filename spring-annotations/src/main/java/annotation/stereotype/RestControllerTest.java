package annotation.stereotype;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {
    public String hello(){
        return "Hello RestControllerTest";
    }
}
